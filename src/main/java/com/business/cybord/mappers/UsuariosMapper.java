package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.cybord.entities.Usuario;
import com.business.cybord.models.dtos.UsuariosDto;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {
	
	Usuario getEntityFromUserDto(UsuariosDto dto);
	UsuariosDto getDtoFromUserEntity(Usuario dto);
	List<UsuariosDto> getUsuariosDtoFromEntities(List<Usuario> entities);

}
