/**
 * 
 */
package com.business.cybord.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.ValidacionAvalMapper;
import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.enums.AvalStatusEnum;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.repositories.dao.ValidacionAvalDao;

/**
 * @author hha0009
 *
 */
@Service
public class ValidacionAvalService {

	@Autowired
	private ValidacionAvalRepository repository;

	@Autowired
	private ValidacionAvalDao dao;

	@Autowired
	private ValidacionAvalMapper mapper;

	public Page<ValidacionAvalDto> findAllAvalesByFiltros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return dao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public ValidacionAvalDto actualizarValidacion(Integer id, ValidacionAvalDto dto) {
		if (dto.getEstatus().equals(AvalStatusEnum.RECHAZO.name())) {
			//TODO: CANCELAR LA SOLICITUD
		} else {
			//TODO: VALIDAR LOS AVALES PARA PASAR LA SOLICITUD
		}
		ValidacionAval entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("No existe la validacion solicitada")));
		entity.setEstatus(dto.getEstatus());
		return mapper.getDtoFromEntity(repository.save(entity));
	}

	public List<ValidacionAvalDto> findAvalesNotApprovedByEmpleado(String noEmpleado) {
		return mapper.getDtosFromEntities(
				repository.findByNoEmpleadoAvalAndEstatus(noEmpleado, AvalStatusEnum.SOLICITUD.name()));
	}

	public List<ValidacionAvalDto> findAvalesBySolicitud(int idSolicitud) {
		return mapper.getDtosFromEntities(repository.findByIdSolicitud(idSolicitud));
	}

}
