package com.business.cybord.services;

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
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.SolicitudRepository;

@Service
public class AtributoSolicitudService {
	@Autowired
	private SolicitudRepository repositorySol;
	@Autowired
	private AtributoSolicitudRepository repository;
	@Autowired
	private SolicitudMapper mapper;

	public List<AtributoSolicitudDto> getAllAtributos() {
		return mapper.AtributoSolicitudDtoToAtributoSolicitud(repository.findAll().stream());
	}

	public AtributoSolicitudDto getAtributoSolicitudById(int idUsuario, int idSolicitud, int idAtributo) {
		Solicitud sol = repositorySol.findByIdUsuarioAndId(idUsuario, idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("La solicitud id=%d no existe del usuario id =%d", idSolicitud, idUsuario)));
		Optional<AtributoSolicitud> entity = repository.findByIdSolicitudAndId(idSolicitud, idAtributo);
		if (entity.isPresent()) {
			return mapper.getDtoFromAtributoSolicitudEntity(entity.get());

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("La el atributo-solicitud id=%d no existe", idAtributo));
		}

	}

	public AtributoSolicitudDto createAtributoSolicitud(int idUsuario, int idSolicitud, AtributoSolicitudDto atributo) {
		Solicitud entity = repositorySol.findByIdUsuarioAndId(idUsuario, idSolicitud)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("la solicitud id= %d del usuario =%d no existe", idSolicitud, idUsuario)));
		AtributoSolicitud nuevo = repository.save(mapper.getEntityFromAtributoSolicitudDto(atributo));
		return mapper.getDtoFromAtributoSolicitudEntity(nuevo);
	}

	public AtributoSolicitudDto actualizarAtributoSolicitud(int idAtributo, AtributoSolicitudDto nuevo) {
		Optional<AtributoSolicitud> atributo = repository.findById(idAtributo);
		if (atributo.isPresent()) {
			atributo.get().update(mapper.getEntityFromAtributoSolicitudDto(nuevo));
			return mapper.getDtoFromAtributoSolicitudEntity(atributo.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el atributo id= %d", idAtributo));
		}
	}

	public void deleteAtributoSolicitud(int idAtributo) {
		Optional<AtributoSolicitud> entity = repository.findById(idAtributo);
		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("La el atributo-solicitud id=%d no existe", idAtributo));
		}

	}
}
