package com.business.cybord.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;

@Service
public class SolicitudService {
	
	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private SolicitudRepository repositorySolicitud;
	@Autowired
	private SolicitudMapper mapper;

	public List<SolicitudDto> getAllSolicitudes(){
		return mapper.SolicitudDtoToSolicitud(repositorySolicitud.findAll().stream());
	}
	
	public SolicitudDto actualizarSolicitudbyId(int id_usuario, int id_solicitud, SolicitudDto nueva) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			solicitud.get().update(mapper.getEntityFromSolicitudDto(nueva));
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
	
	public SolicitudDto crearSolicitudUsuario(int id_usuario, SolicitudDto solicitud) {
		Usuario usuario = repositoryUsuario.findById(id_usuario).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el usuario id= %d no existe", id_usuario)));
		Solicitud nueva = repositorySolicitud.save(mapper.getEntityFromSolicitudDto(solicitud));
		return mapper.getDtoFromSolicitudEntity(nueva);
		
	}
	
	public List<SolicitudDto> getAllSolicitudes(int id_usuario){
		List<Solicitud> solicitudes = new ArrayList<>();
		repositorySolicitud.findByIdUsuario(id_usuario).forEach(solicitudes::add);
		return mapper.SolicitudDtoToSolicitud((solicitudes.stream()));
	}
	
	public SolicitudDto getSolicitudById(int id_usuario, int id_solicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
	
	public void deleteSolicitudById(int id_usuario, int id_solicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			repositorySolicitud.delete(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
		
}
