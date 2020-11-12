package com.business.cybord.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.CatalogoMapper;
import com.business.cybord.models.dtos.CatalogoDto;
import com.business.cybord.models.entities.Catalogo;
import com.business.cybord.repositories.CatalogoRepository;

@Service
public class CatalogoService {
	@Autowired
	private CatalogoRepository repository;
	@Autowired
	private CatalogoMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(CatalogoService.class);

	public List<CatalogoDto> getCatPropiedadByTipo(String tipo) {
		log.info("Buscando CAT_PROPIEDADES de tipo : {}", tipo);
		return mapper.getCatDtosFromEntidades(repository.findByTipo(tipo));
	}

	public CatalogoDto getCatPropiedadByTipoAndNombre(String tipo, String nombre) {
		log.info("Buscando CATALOGO de tipo : {} y nombre : {} ", tipo, nombre);
		return mapper.getCatDtoFromEntidad(repository.findByTipoAndNombre(tipo, nombre)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("El catalogo %s  no contiene el valor %s", tipo, nombre))));

	}

	public CatalogoDto createCatalogoPropiedad(CatalogoDto dto) {
		log.info("creando CAT_PROPIEDADES: [{}]", dto);
		return mapper.getCatDtoFromEntidad(repository.save(mapper.getEntidadFromCatDto(dto)));
	}

	public void deleteCatalogoPropiedadById(Integer id) {
		log.info("borrando CAT_PROPIEDADES con id {} ", id);
		Catalogo entity = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT, "Propiedad ya borrada"));
		repository.delete(entity);
	}

}
