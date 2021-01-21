/**
 * 
 */
package com.business.cybord.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

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
import com.business.cybord.mappers.ValidacionAvalMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.entities.ValidacionSolicitud;
import com.business.cybord.models.enums.AvalStatusEnum;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.repositories.ValidacionSolicitudRepository;
import com.business.cybord.repositories.dao.ValidacionAvalDao;
import com.business.cybord.services.executors.SolicitudExecutorManager;
import com.business.cybord.states.solicitudes.ISolicitud;

/**
 * @author hha0009
 *
 */
@Service
public class ValidacionAvalService {

	@Autowired
	private ValidacionAvalRepository repository;

	@Autowired
	private ValidacionAvalDao dao;

	@Autowired
	private ValidacionAvalMapper mapper;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SolicitudRepository repositorySol;

	@Autowired
	private SolicitudMapper solicitudMapper;

	@Autowired
	private ValidacionSolicitudRepository repositoryValidacion;

	@Autowired
	private SolicitudExecutorManager solicitudExecutorManager;

	public Page<ValidacionAvalDto> findAllAvalesByFiltros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return dao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public ValidacionAvalDto actualizarValidacion(Integer id, ValidacionAvalDto dto) throws IsbgServiceException {
		ValidacionAval entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("No existe la validacion solicitada")));
		if (dto.getEstatus().equals(AvalStatusEnum.RECHAZO.name())) {
			cancelSolicitud(dto.getIdSolicitud(), dto.getNoEmpleadoAval());
		} else {
			List<ValidacionAval> avales = repository.findByIdSolicitud(dto.getIdSolicitud());
			Boolean aprobado = true;
			for (ValidacionAval valida : avales) {
				if (valida.getId() != entity.getId() && !valida.getEstatus().equals(AvalStatusEnum.APROBADO.name())) {
					aprobado = false;
				}
			}
			if (aprobado) {
				approveSolicitud(dto.getIdSolicitud());
			}
		}
		entity.setEstatus(dto.getEstatus());
		return mapper.getDtoFromEntity(repository.save(entity));
	}

	public List<ValidacionAvalDto> findAvalesNotApprovedByEmpleado(String noEmpleado) {
		return mapper.getDtosFromEntities(
				repository.findByNoEmpleadoAvalAndEstatus(noEmpleado, AvalStatusEnum.SOLICITUD.name()));
	}

	public List<ValidacionAvalDto> findAvalesBySolicitud(int idSolicitud) {
		return mapper.getDtosFromEntities(repository.findByIdSolicitud(idSolicitud));
	}

	private void cancelSolicitud(int idSolicitud, String noEmpleadoAval) throws IsbgServiceException {
		Solicitud sol = repositorySol.findById(idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d ", idSolicitud)));
		SolicitudDto solicitudDto = solicitudMapper.getDtoFromSolicitudEntity(sol);
		String motivo = String.format("Rechazo de aval %s", noEmpleadoAval);
		sol.setStatus("Rechazada");
		sol.setStatusDetalle(String.format("Rechazo de aval %s", noEmpleadoAval));
		repositorySol.save(sol);
		ValidacionSolicitudDto validacion = new ValidacionSolicitudDto();
		validacion.setArea(TipoAtributoSolicitudEnum.AVAL.name());
		validacion.setStatusDesc(motivo);
		solicitudExecutorManager.getSolicitudExecutor(solicitudDto.getTipo()).rechazo(solicitudDto, validacion);
	}

	private void approveSolicitud(int idSolicitud) throws IsbgServiceException {
		Solicitud sol = repositorySol.findById(idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d ", idSolicitud)));
		SolicitudDto solicitudDto = solicitudMapper.getDtoFromSolicitudEntity(sol);
		ValidacionSolicitudDto validacion = new ValidacionSolicitudDto();
		validacion.setArea(EventFactoryTypeEnum.VALIDA_AVALES.getReferenceName());
		validacion.setEmail("");
		validacion.setNumeroValidacion(1);
		validacion.setStatus(true);
		ValidacionSolicitud validacionSolicitud=solicitudMapper.getEntityFromValidacionesDto(validacion);
		validacionSolicitud.setSolicitud(sol);
		repositoryValidacion.save(validacionSolicitud);
		sol.setStatus(validaEstadoActual(solicitudDto, validacion));
		solicitudDto = solicitudMapper.getDtoFromSolicitudEntity(repositorySol.save(sol));
	}

	public String validaEstadoActual(SolicitudDto solicitudDto, ValidacionSolicitudDto validacion)
			throws IsbgServiceException {
		try {
			UsuarioDto usuario = usuarioService.getUserById(solicitudDto.getIdUsuario());
			SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum
					.findByReferenceName(solicitudDto.getTipo(), usuario.getTipoUsuario())
					.orElseThrow(() -> new IsbgServiceException(
							String.format("Tipo de solicitud %s no existe", solicitudDto.getTipo()),
							"No existe el tipo de soliciitud", HttpStatus.CONFLICT.value()))
					.getEnumValue();
			State newState = new State(EventFactoryTypeEnum.findByReferenceName(validacion.getArea())
					.orElseThrow(
							() -> new IsbgServiceException(String.format("Evento %s no existe", validacion.getArea()),
									"No existe el evento", HttpStatus.CONFLICT.value()))
					.getState());

			ISolicitud solicitud = sfte.getInstance();
			solicitud.define(solicitudDto.getStatus());
			solicitudDto.getValidaciones().sort((d1, d2) -> d1.getFechaCreacion().compareTo(d2.getFechaCreacion()));
			for (ValidacionSolicitudDto validacionDto : solicitudDto.getValidaciones()) {
				AbstractEvent event = EventFactoryTypeEnum.findByReferenceName(validacionDto.getArea())
						.orElseThrow(() -> new IsbgServiceException(
								String.format("Evento %s no existe", validacion.getArea()), "No existe el evento",
								HttpStatus.CONFLICT.value()))
						.getEnumValue().getInstance(solicitudDto);
				solicitud.fire(event);
			}
			State stado = solicitud.nextState();
			if (newState.equals(stado)) {
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

	public ValidacionAvalDto createAvalRegister(List<AtributoSolicitud> atributos, SolicitudDto SolicitudDto,
			String noEmpleado) {
		long amount = atributos.stream().filter(a -> a.getNombre().contains(TipoAtributoSolicitudEnum.AVAL.name()))
				.count();
		AtributoSolicitud att = atributos.stream()
				.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.DESCUENTO_QUINCENAL.name())).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"La solicitud no tiene monto quincenal como atributo"));
		BigDecimal monto = new BigDecimal(att.getValor()).divide(new BigDecimal(amount), 2, RoundingMode.HALF_UP);

		ValidacionAvalDto aval = new ValidacionAvalDto();
		aval.setIdSolicitud(SolicitudDto.getId());
		aval.setNoEmpleadoAval(noEmpleado);
		UsuarioDto userDto = usuarioService.getUserById(SolicitudDto.getIdUsuario());
		UsuarioDto avalDto = usuarioService.getUserByNoEmpleado(noEmpleado);
		aval.setNombreDeudor(userDto.getNombre());
		aval.setNoEmpleadoDeudor(userDto.getNoEmpleado());
		aval.setEstatus(AvalStatusEnum.SOLICITUD.name());
		aval.setNombreAval(avalDto.getNombre());
		aval.setMontoPrestamo(monto);
		return mapper.getDtoFromEntity(repository.save(mapper.getEntityFromDto(aval)));
	}

}
