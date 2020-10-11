package com.business.cybord.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.composed.UserSolicitudDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.dao.SolicitudDao;
import com.business.cybord.rules.suites.ISuite;
import com.business.cybord.rules.utils.SuiteManager;
import com.business.cybord.states.solicitudes.ISolicitud;

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
	private RulesEngine rulesEngine;
	@Autowired
	private SolicitudDao solicitudDao;

	public Page<UserSolicitudDto> getAllSolicitudes(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return solicitudDao.findAll(PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public List<SolicitudDto> getSolicitudByIdUsuario(int idUsuario) {
		return mapper.solicitudDtoToSolicitud(repositorySolicitud.findUsuario(idUsuario));
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
	
	public SolicitudDto findSolicitudById(int idSolicitud) {
		Optional<Solicitud> solicitud = repositorySolicitud.findById(idSolicitud);
		if (solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("la solicitud id=%d no existe.", idSolicitud));
		}
	}

	public SolicitudDto crearSolicitud(int idUsuario, SolicitudDto solicitudDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(idUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("el usuario id= %d no existe", idUsuario)));
		executeRules(solicitudDto);
		SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum.findByReferenceName(solicitudDto.getTipo())
				.orElseThrow(() -> new IsbgServiceException(
						String.format("Tipo de solicitud %s no existe", solicitudDto.getTipo()),
						"No existe el tipo de soliciitud", HttpStatus.CONFLICT.value()))
				.getEnumValue();
		ISolicitud solicitud = sfte.getInstance();
		solicitudDto.setStatus(solicitud.nextState().getName());
		Solicitud nueva = mapper.getEntityFromSolicitudDto(solicitudDto);
		nueva.setUsuario(usuario);
		nueva = repositorySolicitud.save(nueva);
		nueva.setAtributos(new ArrayList<>());

		for (AtributoSolicitud att : solicitudDto.getAttributesAsList()) {
			att.setSolicitud(nueva);
			nueva.getAtributos().add(atributoSolicitudRepository.save(att));
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
