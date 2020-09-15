package com.business.cybord.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.ValidacionRepository;

@Service
public class SolicitudService {
	@Autowired
	SolicitudRepository repositorySolicitud;
	@Autowired
	ValidacionRepository repositoryValidacion;
	@Autowired
	AtributoSolicitudRepository repositorySolAtrib;
	@Autowired
	SolicitudMapper mapper;
	
	//metodo para probar
	public List<SolicitudDto> getAllSolicitudes(){
		List<Solicitud> solicitudes = new ArrayList<>();
		repositorySolicitud.findAll().forEach(solicitudes::add);
		return mapper.SolicitudDtoToSolicitud(solicitudes.stream());
	}
	
	public SolicitudDto getSolicitudById(int id) {
		Solicitud entity = repositorySolicitud.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe", id)));
		return mapper.getDtoFromSolicitudEntity(entity);
	}
	
	public void deleteSolicitudById(int id) {
		Solicitud entity = repositorySolicitud.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe", id)));
		
		//repositoryValidacion.findBySolicitud(entity).stream().forEach(a->repositoryValidacion.delete(a));;
		//repositorySolAtrib.findBySolicitud(entity).stream().forEach(a->repositorySolAtrib.delete(a));;
		repositorySolicitud.delete(entity);
	}
}
