package com.business.cybord.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.dtos.composed.UserValidacionSolicitudDto;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.Validacion;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.ValidacionRepository;
import com.business.cybord.repositories.dao.ValidacionDao;
import com.business.cybord.services.executors.SolicitudExecutorManager;
import com.business.cybord.states.solicitudes.ISolicitud;

@Service
public class ValidacionService {

	@Autowired
	private ValidacionRepository repositoryValidacion;
	@Autowired
	private SolicitudRepository repositorySol;
	@Autowired
	private SolicitudMapper mapper;
	@Autowired
	private ValidacionDao validacionDao;
	@Autowired
	private SolicitudExecutorManager solicitudExecutorManager;

	public Page<UserValidacionSolicitudDto> getAllValidaciones(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return validacionDao.findAll(parameters,PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public List<ValidacionDto> getAllValidacionesByIdSolicitud(int idSol) {
		return mapper.validacionDtoToValidacion(repositoryValidacion.findByIdSolicitud(idSol));
	}

	public ValidacionDto getValidacionById(int idValidacion) {
		Validacion entity = repositoryValidacion.findById(idValidacion)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("La validacion id=%d no existe", idValidacion)));
		return mapper.getDtoFromValidacionesEntity(entity);
	}

	public ValidacionDto crearValidacion(int idUsuario, int idSolicitud, ValidacionDto validacion)
			throws IsbgServiceException {
		Solicitud sol = repositorySol.findByIdUsuarioAndId(idUsuario, idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d del usuario =%d no existe", idSolicitud, idUsuario)));
		if (validacion.isStatus()) {
			SolicitudDto solicitudDto = mapper.getDtoFromSolicitudEntity(sol);
			sol.setStatus(validaEstadoActual(solicitudDto, validacion));
			solicitudDto=mapper.getDtoFromSolicitudEntity(repositorySol.save(sol));
			validacion.setNumeroValidacion(solicitudDto.getValidaciones().size() + 1);
			Validacion val = mapper.getEntityFromValidacionesDto(validacion);
			val.setSolicitud(sol);
			solicitudExecutorManager.getSolicitudExecutor(solicitudDto.getTipo()).execute(solicitudDto);
			return mapper.getDtoFromValidacionesEntity(repositoryValidacion.save(val));
		} else {
			SolicitudDto solicitudDto = mapper.getDtoFromSolicitudEntity(sol);
			sol.setStatus("Rechazada");
			sol.setStatusDetalle(validacion.getStatusDesc());
			repositorySol.save(sol);
			Validacion val = mapper.getEntityFromValidacionesDto(validacion);
			val.setSolicitud(sol);
			validacion.setNumeroValidacion(solicitudDto.getValidaciones().size() + 1);
			return mapper.getDtoFromValidacionesEntity(repositoryValidacion.save(val));
		}

	}

	public String validaEstadoActual(SolicitudDto solicitudDto, ValidacionDto validacion) throws IsbgServiceException {
		try {
			SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum.findByReferenceName(solicitudDto.getTipo())
					.orElseThrow(() -> new IsbgServiceException(
							String.format("Tipo de solicitud %s no existe", solicitudDto.getTipo()),
							"No existe el tipo de soliciitud", HttpStatus.CONFLICT.value()))
					.getEnumValue();
			if (solicitudDto.getValidaciones().stream()
					.anyMatch(a -> a.getArea().equals(EventFactoryTypeEnum.VALIDA_GERENCIA.getReferenceName())
							&& validacion.getArea().equals(EventFactoryTypeEnum.VALIDA_GERENCIA.getReferenceName()))) {
				validacion.setArea(EventFactoryTypeEnum.VALIDA_GERENCIA2.getReferenceName());
			}
			State newState = new State(EventFactoryTypeEnum.findByReferenceName(validacion.getArea())
					.orElseThrow(
							() -> new IsbgServiceException(String.format("Evento %s no existe", validacion.getArea()),
									"No existe el evento", HttpStatus.CONFLICT.value()))
					.getState());
			
			ISolicitud solicitud = sfte.getInstance();
			solicitud.define(solicitudDto.getStatus());
			solicitudDto.getValidaciones().sort((d1, d2) -> d1.getFechaCreacion().compareTo(d2.getFechaCreacion()));
			for (ValidacionDto validacionDto : solicitudDto.getValidaciones()) {
				AbstractEvent event = EventFactoryTypeEnum.findByReferenceName(validacionDto.getArea())
						.orElseThrow(() -> new IsbgServiceException(
								String.format("Evento %s no existe", validacion.getArea()), "No existe el evento",
								HttpStatus.CONFLICT.value()))
						.getEnumValue().getInstance(solicitudDto);
				solicitud.fire(event);
			}
			if (newState.equals(solicitud.nextState())) {
				return solicitud.nextState().getName();
			}
			throw new IsbgServiceException(
					String.format("El estado %s no es el siguiente en el flujo %s", validacion.getArea(),
							solicitudDto.getTipo()),
					"Error validando el estado de la solicitud", HttpStatus.CONFLICT.value());
		} catch (FiniteStateMachineException e) {
			throw new IsbgServiceException("Error validando el estado de la solicitud", e.getMessage(),
					HttpStatus.CONFLICT.value());
		}
	}

	public ValidacionDto actualizarValidacion(int idValidacion, ValidacionDto nueva) {
		Optional<Validacion> validacion = repositoryValidacion.findById(idValidacion);
		if (validacion.isPresent()) {
			validacion.get().update(mapper.getEntityFromValidacionesDto(nueva));
			return mapper.getDtoFromValidacionesEntity(validacion.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la validacion id= %d", idValidacion));
		}
	}

	public void deleteValidacion(int idValidacion) {
		Optional<Validacion> entity = repositoryValidacion.findById(idValidacion);
		if (entity.isPresent()) {
			repositoryValidacion.delete(entity.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("La validacion id=%d no existe", idValidacion));
		}

	}

}
