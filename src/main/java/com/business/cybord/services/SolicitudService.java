package com.business.cybord.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.rules.suites.ISuite;
import com.business.cybord.rules.utils.SuiteManager;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RulesEngine;


@Service
public class SolicitudService {

	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private SolicitudRepository repositorySolicitud;
	@Autowired
	private AtributoSolicitudRepository atributoSolicitudRepository;
	@Autowired
	private SolicitudMapper mapper;
	@Autowired
	private SuiteManager suiteManager;
	@Autowired
	protected RulesEngine rulesEngine;

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

	public SolicitudDto crearSolicitud(int idUsuario, SolicitudDto solicitud) throws IsbgServiceException {
		repositoryUsuario.findById(idUsuario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("el usuario id= %d no existe", idUsuario)));
		executeRules(solicitud);
		Solicitud nueva = repositorySolicitud.save(mapper.getEntityFromSolicitudDto(solicitud));
		nueva.setAtributos(new ArrayList<>());
		for (AtributoSolicitudDto att : solicitud.getAtributos()) {
			att.setIdSolicitud(nueva.getId());
			nueva.getAtributos().add(atributoSolicitudRepository.save(mapper.getEntityFromAtributoSolicitudDto(att)));
		}
		return mapper.getDtoFromSolicitudEntity(nueva);
	}

	private void executeRules(SolicitudDto solicitudDto) throws IsbgServiceException {
		ISuite suite = suiteManager.getSolicitudSuite(solicitudDto.getTipo());
		Facts facts = new Facts();
		List<String> results = new ArrayList<>();
		facts.put("solicitud", solicitudDto);
		facts.put("results", results);
		rulesEngine.fire(suite.getSuite(), facts);
		if (!results.isEmpty()) {
			throw new IsbgServiceException(results.toString(), "errores durante la validacion de la solicitud.",
					HttpStatus.CONFLICT.value());
		}
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
