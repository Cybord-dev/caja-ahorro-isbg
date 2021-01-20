/**
 * 
 */
package com.business.cybord.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.ValidacionAvalMapper;
import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.repositories.ValidacionAvalRepository;

/**
 * @author hha0009
 *
 */
@Service
public class ValidacionAvalService {
	
	@Autowired
	private ValidacionAvalRepository repository;
	
	@Autowired
	private ValidacionAvalMapper mapper;
	

	public List<ValidacionAvalDto> findAllAvalesByFiltros() {
		//TODO implements dynamic extraction
		return mapper.getDtosFromEntities(repository.findAll());
	}
	
	public List<ValidacionAvalDto> findAvalesNotApprovedByEmpleado(String noEmpleado) {
		return mapper.getDtosFromEntities(repository.findByNoEmpleadoAval(noEmpleado));
	}
	
	public List<ValidacionAvalDto> findAvalesBySolicitud(int idSolicitud) {
		return mapper.getDtosFromEntities(repository.findByIdSolicitud(idSolicitud));
	}

}
