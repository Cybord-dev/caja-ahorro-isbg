package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.cybord.entities.CatalogoPropiedad;
import com.business.cybord.models.dtos.CatalogoPropiedadDto;

@Mapper(componentModel = "spring")
public interface CatalogoPropiedadMapper {
	CatalogoPropiedad getEntidadFromCatDto(CatalogoPropiedadDto dto);
	
	
	CatalogoPropiedadDto getCatDtoFromEntidad(CatalogoPropiedad dto);
	List<CatalogoPropiedadDto> getCatDtosFromEntidades(List<CatalogoPropiedad> dto);
}
