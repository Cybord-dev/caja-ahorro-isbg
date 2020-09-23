package com.business.cybord.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.utils.DateHelper;

@Service
public class SolicitudService {

	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private SolicitudRepository repositorySolicitud;
	@Autowired
	private SolicitudMapper mapper;
	public List<SolicitudDto> getAllSolicitudes() {
		return mapper.solicitudDtoToSolicitud(repositorySolicitud.findAll());
	}

	public List<SolicitudDto> getSolicitudByIdUsuario(int idUsuario) {
		return mapper.solicitudDtoToSolicitud(repositorySolicitud.findByIdUsuario(idUsuario));
	}
	

	public SolicitudDto getSolicitudByUsuarioAndId(int idUsuario, int idSolicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(idUsuario, idSolicitud);
		if (solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe con el usuario id=%d", idSolicitud, idUsuario));
		}
	}

	
	public Page<SolicitudDto> getSolicitudesByParametros(String email, Integer tipo, Integer estatus, int page, int size, Date since, Date to){
		if(email != null) {
			int coma = email.indexOf(",");
			email = email.substring(0, coma);
		}
		Date inicio = (since == null) ? new DateTime().minusYears(1).toDate() : since;
		Date fin = (to == null) ? new Date() : to;
		fin = DateHelper.getMidnight(fin);
		Page<Solicitud> resultado = null;
		if(email != null) {
			if(tipo != null) {
				if(estatus != null) {
					resultado = repositorySolicitud.findByParams(String.format("%%%s%%", email), tipo,estatus, inicio, fin, PageRequest.of(page, size));
				}else {
					resultado = repositorySolicitud.findByParams(String.format("%%%s%%", email), tipo, inicio, fin, PageRequest.of(page, size));
				}
			}else {
				resultado = repositorySolicitud.findByEmail(String.format("%%%s%%", email), inicio, fin, PageRequest.of(page, size));
			}
		}else if(tipo != null) {
			if(estatus != null) {
				resultado = repositorySolicitud.findByParams( tipo, estatus, inicio, fin, PageRequest.of(page, size));
			}else {
				resultado = repositorySolicitud.findByParams( tipo, inicio, fin, PageRequest.of(page, size));
			}
			
		}else if(estatus != null){
			resultado = repositorySolicitud.findByEstatus( estatus, inicio, fin, PageRequest.of(page, size));
		}else {
			resultado = repositorySolicitud.findByParams( inicio, fin, PageRequest.of(page, size));
		}
		
		return new PageImpl<>(mapper.solicitudDtoToSolicitud(resultado.getContent()), resultado.getPageable(),resultado.getTotalElements());
	    
	}
	public SolicitudDto crearSolicitud(int idUsuario, SolicitudDto solicitud) {
		repositoryUsuario.findById(idUsuario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("el usuario id= %d no existe", idUsuario)));
		Solicitud nueva = repositorySolicitud.save(mapper.getEntityFromSolicitudDto(solicitud));
		return mapper.getDtoFromSolicitudEntity(nueva);
	}

	public SolicitudDto actualizarSolicitud(int idSolicitud, SolicitudDto nueva) {
		Optional<Solicitud> solicitud = repositorySolicitud.findById(idSolicitud);
		if (solicitud.isPresent()) {
			solicitud.get().update(mapper.getEntityFromSolicitudDto(nueva));
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe", idSolicitud));
		}
	}

	public void deleteSolicitud(int idSolicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findById(idSolicitud);
		if (solicitud.isPresent()) {
			repositorySolicitud.delete(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe", idSolicitud));
		}
	}

}
