package com.business.cybord.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Validacion;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.repositories.ValidacionRepository;

@Service
public class ValidacionService {
	
	@Autowired
	ValidacionRepository repositoryValidacion;
	@Autowired
	SolicitudMapper mapper;
	
	public ValidacionDto getValidacionById(int id) {
		Validacion entity = repositoryValidacion.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id)));
		return mapper.getDtoFromValidacionesEntity(entity);
	}
	
	public void deleteValidacionById(int id) {
		Validacion entity = repositoryValidacion.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id)));
		repositoryValidacion.delete(entity);
	}
}
