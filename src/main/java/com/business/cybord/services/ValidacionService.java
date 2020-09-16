package com.business.cybord.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<ValidacionDto> getAllValidaciones(){
		List<Validacion> validaciones = new ArrayList<>();
		repositoryValidacion.findAll().forEach(validaciones::add);
		return mapper.ValidacionDtoToValidacion(validaciones.stream());
	}
}
