package com.business.cybord.services;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.CatalogoPropiedad;
import com.business.cybord.mappers.CatalogoPropiedadMapper;
import com.business.cybord.models.dtos.CatalogoPropiedadDto;
import com.business.cybord.repositories.CatalogoPropiedadRepository;

@Service
public class CatalogoPropiedadService {
	@Autowired
	private CatalogoPropiedadRepository repository;
	@Autowired
	private CatalogoPropiedadMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(CatalogoPropiedadService.class);
	
	public List<CatalogoPropiedadDto> getCatPropiedadByTipo(String tipo) {
		log.info("Buscando CAT_PROPIEDADES de tipo : {}", tipo);
		List<CatalogoPropiedad> entities = repository.findByTipo(tipo);
		if(entities.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No hay CAT_PROPIEDADES con tipo %s", tipo));
		}else {
			return mapper.CatalogoPropiedadDtoToCatalogoPropiedad(entities.stream());
			
		}
	}
	
	public CatalogoPropiedadDto getCatPropiedadByTipoAndNombre(String tipo, String nombre) {
		log.info("Buscando CAT_PROPIEDADES de tipo : {} y nombre : {} ", tipo, nombre);
		Optional<CatalogoPropiedad> entity = repository.findByTipoAndNombre(tipo, nombre);
		if(entity.isPresent()) {
			return mapper.getDtoFromCatalogoPropiedadEntity(entity.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No hay CAT_PROPIEDADES con tipo =%s y nombre=%s", tipo, nombre));
		}
				
	}
	
	public CatalogoPropiedadDto createCatalogoPropiedad(CatalogoPropiedadDto dto) {
		log.info("creando CAT_PROPIEDADES: [{}]",dto);
		Optional<CatalogoPropiedad> entity = repository.findById(dto.getId());
		if(!entity.isPresent()) {
			return mapper.getDtoFromCatalogoPropiedadEntity(repository.save(mapper.getEntityFromCatalogoPropiedadDto(dto)));
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El CAT_PROPIEDADES con id=%d ya existe", dto.getId()));
		}
	}
	
	public void deleteCatalogoPropiedadByTipoAndNombre(String tipo, String nombre) {
		log.info("borrando CAT_PROPIEDADES de tipo : {} y nombre : {} ", tipo, nombre);
		CatalogoPropiedadDto entity = getCatPropiedadByTipoAndNombre(tipo, nombre);
		repository.delete(mapper.getEntityFromCatalogoPropiedadDto(entity));
	}
	
}
