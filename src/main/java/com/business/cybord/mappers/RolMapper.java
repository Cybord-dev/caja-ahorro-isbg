package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.cybord.entities.Rol;
import com.business.cybord.models.dtos.RolDto;


@Mapper(componentModel = "spring")
public interface RolMapper {
	
	Rol getEntityFromRolDto(RolDto dto);
	
	RolDto getDtoFromRolEntity(Rol entiti);


	List<RolDto> getDtosFromRolsEntity(List<Rol> entities);

	List<Rol> getEntitysFromRolDtos(List<RolDto> dto);
}
