package com.business.cybord.mappers;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;

import com.business.cybord.entities.CatalogoPropiedad;
import com.business.cybord.models.dtos.CatalogoPropiedadDto;

@Mapper(componentModel = "spring")
public interface CatalogoPropiedadMapper {
	CatalogoPropiedad getEntityFromCatalogoPropiedadDto(CatalogoPropiedadDto dto);
	CatalogoPropiedadDto getDtoFromCatalogoPropiedadEntity(CatalogoPropiedad dto);
	List<CatalogoPropiedadDto> CatalogoPropiedadDtoToCatalogoPropiedad(Stream<CatalogoPropiedad> dto);
}
