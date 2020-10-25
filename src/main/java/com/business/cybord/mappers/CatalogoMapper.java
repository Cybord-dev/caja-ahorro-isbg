package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.cybord.models.dtos.CatalogoOficinaDto;
import com.business.cybord.models.entities.CatalogoOficina;

@Mapper
public interface CatalogoMapper {

	CatalogoOficinaDto getCatDtoFromEntidad(CatalogoOficina entity);
	CatalogoOficina getEntityFromDto(CatalogoOficinaDto entity);
	List<CatalogoOficinaDto> getCatDtosFromEntities(List<CatalogoOficina> entity);
}
