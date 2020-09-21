package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.entities.CatalogoPropiedad;
import com.business.cybord.models.dtos.CatalogoPropiedadDto;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CatalogoPropiedadMapper {
	CatalogoPropiedad getEntidadFromCatDto(CatalogoPropiedadDto dto);
	
	
	CatalogoPropiedadDto getCatDtoFromEntidad(CatalogoPropiedad dto);
	List<CatalogoPropiedadDto> getCatDtosFromEntidades(List<CatalogoPropiedad> dto);
}
