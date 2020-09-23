package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Validacion;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.ValidacionRepository;

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
		Validacion entity = repositoryValidacion
				.findById(idValidacion)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("La validacion id=%d no existe", idValidacion)));
		return mapper.getDtoFromValidacionesEntity(entity);
	}

	public ValidacionDto crearValidacion(int idUsuario, int idSolicitud, ValidacionDto validacion) {
		Solicitud solicitud = repositorySol.findByIdUsuarioAndId(idUsuario, idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d del usuario =%d no existe", idSolicitud, idUsuario)));
		
			Validacion nueva = repositoryValidacion.save(mapper.getEntityFromValidacionesDto(validacion));
			nueva.setSolicitud(solicitud);
			return mapper.getDtoFromValidacionesEntity(nueva);
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
