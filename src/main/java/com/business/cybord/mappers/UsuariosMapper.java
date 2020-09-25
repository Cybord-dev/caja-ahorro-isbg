package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.models.entities.Usuario;

@Mapper
@DecoratedWith(UsuariosMapperDecorator.class)
public interface UsuariosMapper {
	@Mapping(target = "roles", ignore = true)
	Usuario getEntityFromUserDto(UsuariosDto dto);

	@Mapping(target = "roles", ignore = true)
	UsuariosDto getDtoFromUserEntity(Usuario dto);

	List<UsuariosDto> getUsuariosDtoFromEntities(List<Usuario> entities);

}
