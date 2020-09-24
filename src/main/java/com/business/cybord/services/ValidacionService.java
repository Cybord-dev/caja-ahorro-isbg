package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.Validacion;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.ValidacionRepository;
import com.business.cybord.states.solicitudes.ISolicitud;

@Service
public class ValidacionService {

	@Autowired
	private ValidacionRepository repositoryValidacion;
	@Autowired
	private SolicitudRepository repositorySol;
	@Autowired
	private SolicitudMapper mapper;

	public List<ValidacionDto> getAllValidaciones() {
		return mapper.validacionDtoToValidacion(repositoryValidacion.findAll());
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
		SolicitudDto solicitudDto = mapper.getDtoFromSolicitudEntity(repositorySol
				.findByIdUsuarioAndId(idUsuario, idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d del usuario =%d no existe", idSolicitud, idUsuario))));
		if (validaEstadoActual(solicitudDto, validacion)) {
			validacion.setNumeroValidacion(solicitudDto.getValidaciones().size()+1);
			Validacion nueva = repositoryValidacion.save(mapper.getEntityFromValidacionesDto(validacion));
			return mapper.getDtoFromValidacionesEntity(nueva);
		} else {
			throw new IsbgServiceException(
					String.format("El estado %s no es el siguiente en el flujo %s", validacion.getArea(),
							solicitudDto.getTipo()),
					"Error validando el estado de la solicitud", HttpStatus.CONFLICT.value());
		}

	}

	public boolean validaEstadoActual(SolicitudDto solicitudDto, ValidacionDto validacion) throws IsbgServiceException {
		try {
			SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum.findByReferenceName(solicitudDto.getTipo())
					.getEnumValue();
			State newState = new State(EventFactoryTypeEnum.findByReferenceName(validacion.getArea()).getState());
			ISolicitud solicitud = sfte.getInstance();
			solicitud.define(solicitudDto.getStatus());
			solicitudDto.getValidaciones().sort((d1, d2) -> d1.getFechaCreacion().compareTo(d2.getFechaCreacion()));
			for (ValidacionDto validacionDto : solicitudDto.getValidaciones()) {
				AbstractEvent event = EventFactoryTypeEnum.findByReferenceName(validacionDto.getArea()).getEnumValue()
						.getInstance(solicitudDto);
				solicitud.fire(event);
			}
			if (newState.equals(solicitud.nextState())) {
					return true;
			}
			return false;
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
