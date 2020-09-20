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

	public List<SolicitudDto> getAllSolicitudes(int id_usuario) {
		return mapper.SolicitudDtoToSolicitud(repositorySolicitud.findByIdUsuario(id_usuario));
	}

	public SolicitudDto getSolicitudById(int id_usuario, int id_solicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if (solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}

	public SolicitudDto crearSolicitud(int idUsuario, SolicitudDto solicitud) {
		repositoryUsuario.findById(idUsuario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("el usuario id= %d no existe", idUsuario)));
		Solicitud nueva = repositorySolicitud.save(mapper.getEntityFromSolicitudDto(solicitud));
		return mapper.getDtoFromSolicitudEntity(nueva);
	}

	public SolicitudDto actualizarSolicitudbyId(int id_solicitud, SolicitudDto nueva) {
		Optional<Solicitud> solicitud = repositorySolicitud.findById(id_solicitud);
		if (solicitud.isPresent()) {
			solicitud.get().update(mapper.getEntityFromSolicitudDto(nueva));
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe", id_solicitud));
		}
	}

	public void deleteSolicitudById(int idSolicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findById(idSolicitud);
		if (solicitud.isPresent()) {
			repositorySolicitud.delete(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe", idSolicitud));
		}
	}

}
