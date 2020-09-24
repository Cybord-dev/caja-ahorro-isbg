package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.entities.Prestamo;


@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PrestamoMapper {
	
	Prestamo getEntityFromDto(PrestamoDto dto);
	
	PrestamoDto getDtoFromEntity(Prestamo entiti);

	List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities);

	List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto);
}
