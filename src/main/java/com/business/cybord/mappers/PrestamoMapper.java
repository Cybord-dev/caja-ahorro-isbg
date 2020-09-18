package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.cybord.entities.Prestamo;

import com.business.cybord.models.dtos.PrestamoDto;



@Mapper(componentModel = "spring")
public interface PrestamoMapper {
	
	Prestamo getEntityFromDto(PrestamoDto dto);
	
	PrestamoDto getDtoFromEntity(Prestamo entiti);

	List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities);

	List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto);
}
