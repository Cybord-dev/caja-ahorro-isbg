package com.business.cybord.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.models.entities.Usuario;

public class UsuariosMapperDecorator implements UsuariosMapper {

	@Autowired
	private UsuariosMapper delegate;

	@Override
	public Usuario getEntityFromUserDto(UsuariosDto dto) {
		Usuario entity = delegate.getEntityFromUserDto(dto);
		return entity;
	}

	@Override
	public UsuariosDto getDtoFromUserEntity(Usuario entity) {
		UsuariosDto dto = delegate.getDtoFromUserEntity(entity);
		if (entity.getRoles() != null) {
			List<String> roles = entity.getRoles().stream().map(a -> a.getRolname().getNombre())
					.collect(Collectors.toList());
			dto.setRoles(roles);
    } 
		return dto;
	}

	@Override
	public List<UsuariosDto> getUsuariosDtoFromEntities(List<Usuario> entities) {
		List<UsuariosDto> dtos = delegate.getUsuariosDtoFromEntities(entities);
		return dtos;
	}

}
