package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;
import com.business.cybord.entities.Validacion;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.ValidacionRepository;

@Service
public class ValidacionService {
	
	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private ValidacionRepository repositoryValidacion;
	@Autowired
	private SolicitudRepository repositorySol;
	@Autowired
	private SolicitudMapper mapper;
	
	public List<ValidacionDto> getAllValidaciones(){
		return mapper.ValidacionDtoToValidacion(repositoryValidacion.findAll().stream());
	}
	
	public ValidacionDto crearValidacion(int id_usuario, int id_solicitud,ValidacionDto validacion) {
		Optional<Solicitud> solicitud = repositorySol.findById(id_solicitud);
		Optional<Usuario> usuario = repositoryUsuario.findById(id_usuario);
		if(!solicitud.isPresent() && !usuario.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("solicitud id= %d o usuario id=%d no existe", id_solicitud, id_usuario));
		}else {
			Validacion nueva = repositoryValidacion.save(mapper.getEntityFromValidacionesDto(validacion));
			return mapper.getDtoFromValidacionesEntity(nueva);
		}
	}
	
	public ValidacionDto actualizarValidacionById(int idUsuario, int idSolicitud, int idValidacion, ValidacionDto nueva) {
		Optional<Validacion> validacion = repositoryValidacion.findByIdUsuarioAndIdAndIdSolicitud(idUsuario, idValidacion, idSolicitud);
		if(validacion.isPresent()) {
			validacion.get().update(mapper.getEntityFromValidacionesDto(nueva));
			return mapper.getDtoFromValidacionesEntity(validacion.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la validacion id= %d perteneciente a solicitud id=%d validada por usuario id=%d no existe", idValidacion, idSolicitud, idValidacion));
		}
	}
	
	public ValidacionDto getValidacionById(int id_usuario, int id_solicitud, int id_validacion) {
		Validacion entity = repositoryValidacion.findByIdUsuarioAndIdAndIdSolicitud(id_usuario, id_validacion, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id_validacion)));
		return mapper.getDtoFromValidacionesEntity(entity);
	}
	
	public void deleteValidacionById(int id_usuario, int id_solicitud, int id_validacion) {
		Optional<Validacion> entity = repositoryValidacion.findByIdUsuarioAndIdAndIdSolicitud(id_usuario, id_validacion, id_solicitud);
		if(entity.isPresent()) {
			repositoryValidacion.delete(entity.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id_validacion));
		}
		
	}

}
