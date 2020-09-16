package com.business.cybord.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.repositories.AtributoSolicitudRepository;

@Service
public class AtributoSolicitudService {
	@Autowired
	AtributoSolicitudRepository repository;
	@Autowired
	SolicitudMapper mapper;
	
	public AtributoSolicitudDto getAtributoSolicitudById(int id) {
		AtributoSolicitud entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe", id)));
		return mapper.getDtoFromAtributoSolicitudEntity(entity);
	}
	
	public void deleteAtributoSolicitudById(int id) {
		AtributoSolicitud entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe", id)));
		repository.delete(entity);
	}
}
