/**
 * 
 */
package com.business.cybord.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.AceptacionAvalMapper;
import com.business.cybord.models.dtos.AceptacionAvalDto;
import com.business.cybord.repositories.AceptacionAvalRepository;

/**
 * @author hha0009
 *
 */
@Service
public class AceptacionAvalService {
	
	@Autowired
	private AceptacionAvalRepository repository;
	
	@Autowired
	private AceptacionAvalMapper mapper;
	

	public List<AceptacionAvalDto> findAllAceptaciones() {
		//TODO implements dynamic extraction
		return mapper.getDtosFromEntities(repository.findAll());
	}
	
	public List<AceptacionAvalDto> findAceptacionesFromSolucitud(int idSolicitud) {
		return mapper.getDtosFromEntities(repository.findByIdSolicitud(idSolicitud));
	}

}
