package com.business.cybord.services;


import java.util.ArrayList;
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
		repositorySolicitud.delete(entity);
	}
	
	public AtributoSolicitudDto createAtributoSolicitud(int idSolicitud, AtributoSolicitudDto atributo) {
		Solicitud entity = repositorySolicitud.findById(idSolicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id= %d no existe", idSolicitud)));
		AtributoSolicitud nuevo = repositorySolAtrib.save(mapper.getEntityFromAtributoSolicitudDto(atributo));
		return mapper.getDtoFromAtributoSolicitudEntity(nuevo);
	}
	
	public AtributoSolicitudDto actualizarAtributoSolicitud(int idSolicitud, int idAtributo, AtributoSolicitudDto nuevo) {
		Solicitud solicitud = repositorySolicitud.findById(idSolicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id= %d no existe", idSolicitud)));
		Optional<AtributoSolicitud> atributo = repositorySolAtrib.findBySolicitudAndId(solicitud, idAtributo);
		if(atributo.isPresent()) {
			atributo.get().update(mapper.getEntityFromAtributoSolicitudDto(nuevo));
			return mapper.getDtoFromAtributoSolicitudEntity(atributo.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el atributo id= %d no existe", idAtributo));
		}
	}
		
}
