package com.business.cybord.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.repositories.SolicitudRepository;

@Service
public class SolicitudService {
	@Autowired
	SolicitudRepository repositorySolicitud;
	@Autowired
	SolicitudMapper mapper;

	public List<SolicitudDto> getAllSolicitudes(){
		List<Solicitud> solicitudes = new ArrayList<>();
		repositorySolicitud.findAll().forEach(solicitudes::add);
		return mapper.SolicitudDtoToSolicitud(solicitudes.stream());
	}
		
}
