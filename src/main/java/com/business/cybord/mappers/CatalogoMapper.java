package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.CatalogoDto;
import com.business.cybord.models.entities.Catalogo;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CatalogoMapper {
	Catalogo getEntidadFromCatDto(CatalogoDto dto);
	
	
	CatalogoDto getCatDtoFromEntidad(Catalogo dto);
	List<CatalogoDto> getCatDtosFromEntidades(List<Catalogo> dto);
}
