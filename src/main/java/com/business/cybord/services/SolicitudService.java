package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Solicitud;
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

	public List<SolicitudDto> getAllSolicitudes() {
		return mapper.SolicitudDtoToSolicitud(repositorySolicitud.findAll());
	}

	public List<SolicitudDto> getAllSolicitudes(int idUsuario) {
		return mapper.SolicitudDtoToSolicitud(repositorySolicitud.findByIdUsuario(idUsuario));
	}

	public SolicitudDto getSolicitudById(int idUsuario, int idSolicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(idUsuario, idSolicitud);
		if (solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe con el usuario id=%d", idSolicitud, idUsuario));
		}
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
