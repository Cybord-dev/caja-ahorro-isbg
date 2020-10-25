package com.business.cybord.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.CatalogoMapper;
import com.business.cybord.models.dtos.CatalogoOficinaDto;
import com.business.cybord.repositories.CatalogoOficinaRepository;

@Service
public class CatalogoService {

	@Autowired
	private CatalogoOficinaRepository repository;

	@Autowired
	private CatalogoMapper mapper;

	public List<CatalogoOficinaDto> getCatalogosOficina() {
		return mapper.getCatDtosFromEntities(repository.findAll());
	}

}
