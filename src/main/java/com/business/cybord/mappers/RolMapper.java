package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.RolDto;
import com.business.cybord.models.entities.Rol;


@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RolMapper {
	
	Rol getEntityFromRolDto(RolDto dto);
	
	RolDto getDtoFromRolEntity(Rol entiti);


	List<RolDto> getDtosFromRolsEntity(List<Rol> entities);

	List<Rol> getEntitysFromRolDtos(List<RolDto> dto);
}
