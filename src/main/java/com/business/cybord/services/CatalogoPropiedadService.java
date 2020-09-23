package com.business.cybord.services;

import java.util.List;

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
		return mapper.getCatDtosFromEntidades(repository.findByTipo(tipo));
	}

	public CatalogoPropiedadDto getCatPropiedadByTipoAndNombre(String tipo, String nombre) {
		log.info("Buscando CAT_PROPIEDADES de tipo : {} y nombre : {} ", tipo, nombre);
		return mapper.getCatDtoFromEntidad(repository.findByTipoAndNombre(tipo, nombre)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("No hay CAT_PROPIEDADES con tipo =%s y nombre=%s", tipo, nombre))));

	}

	public CatalogoPropiedadDto createCatalogoPropiedad(CatalogoPropiedadDto dto) {
		log.info("creando CAT_PROPIEDADES: [{}]", dto);
		return mapper.getCatDtoFromEntidad(repository.save(mapper.getEntidadFromCatDto(dto)));
	}

	public void deleteCatalogoPropiedadById(Integer id) {
		log.info("borrando CAT_PROPIEDADES con id {} ", id);
		CatalogoPropiedad entity = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT, "Propiedad ya borrada"));
		repository.delete(entity);
	}

}
