package com.business.cybord.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<AtributoSolicitudDto> getAllAtributos(){
		List<AtributoSolicitud> atributos = new ArrayList<>();
		repository.findAll().forEach(atributos::add);
		return mapper.AtributoSolicitudDtoToAtributoSolicitud(atributos.stream());
	}
}
