package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.Solicitud;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.SolicitudRepository;

@Service
public class AtributoSolicitudService {
	@Autowired
	private SolicitudRepository repositorySol;
	@Autowired
	private AtributoSolicitudRepository repository;
	@Autowired
	private SolicitudMapper mapper;
	
	public List<AtributoSolicitudDto> getAllAtributos(){
		return mapper.AtributoSolicitudDtoToAtributoSolicitud(repository.findAll().stream());
	}

	public AtributoSolicitudDto createAtributoSolicitud(int id_usuario, int id_solicitud, AtributoSolicitudDto atributo) {
		Solicitud entity = repositorySol.findByIdUsuarioAndId(id_usuario, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id= %d del usuario =%d no existe", id_solicitud, id_usuario)));
		AtributoSolicitud nuevo = repository.save(mapper.getEntityFromAtributoSolicitudDto(atributo));
		return mapper.getDtoFromAtributoSolicitudEntity(nuevo);
	}
	
	public AtributoSolicitudDto actualizarAtributoSolicitud(int id_usuario, int id_solicitud, int id_atributo, AtributoSolicitudDto nuevo) {
		Optional<AtributoSolicitud> atributo = repository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(atributo.isPresent()) {
			atributo.get().update(mapper.getEntityFromAtributoSolicitudDto(nuevo));
			return mapper.getDtoFromAtributoSolicitudEntity(atributo.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el atributo id= %d de la solicitud id=%d del usuario id=%d no existe", id_atributo, id_solicitud, id_usuario));
		}
	}
	
	public AtributoSolicitudDto getAtributoSolicitudById(int id_usuario, int id_solicitud, int id_atributo) {
		Solicitud sol = repositorySol.findByIdUsuarioAndId(id_usuario, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe del usuario id =%d", id_solicitud, id_usuario)));
		Optional<AtributoSolicitud> entity = repository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(entity.isPresent()) {
			return mapper.getDtoFromAtributoSolicitudEntity(entity.get());
			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La el atributo-solicitud id=%d no existe", id_atributo));
		}
		
	}
	
	public void deleteAtributoSolicitudById(int id_usuario, int id_solicitud, int id_atributo) {
		Optional<AtributoSolicitud> entity = repository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(entity.isPresent()) {
			repository.delete(entity.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La el atributo-solicitud id=%d no existe", id_atributo));
		}
		
	}
}
