package com.business.cybord.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.cybord.models.dtos.UserInfoDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;

public class UsuarioMapperDecorator implements UsuariosMapper {

	@Autowired
	private UsuariosMapper delegate;

	@Override
	public Usuario getEntityFromUserDto(UsuarioDto dto) {
		Usuario entity = delegate.getEntityFromUserDto(dto);
		return entity;
	}

	@Override
	public UsuarioDto getDtoFromUserEntity(Usuario entity) {
		UsuarioDto dto = delegate.getDtoFromUserEntity(entity);
		if (entity.getRoles() != null) {
			List<String> roles = entity.getRoles().stream().map(a -> a.getRolname().getNombre())
					.collect(Collectors.toList());
			dto.setRoles(roles);
		}
		if(entity.getDatosUsuario() !=null) {
			dto.setDatosUsuario(entity.getDatosUsuario().stream().collect(Collectors.toMap(DatosUsuario::getTipoDato, DatosUsuario::getDato)));
		}
		
		return dto;
	}

	@Override
	public List<UsuarioDto> getUsuariosDtoFromEntities(List<Usuario> entities) {
		List<UsuarioDto> dtos = delegate.getUsuariosDtoFromEntities(entities);
		return dtos;
	}

	@Override
	public UserInfoDto getUserInfoFromUsuario(Usuario entity) {
		UserInfoDto dto = delegate.getUserInfoFromUsuario(entity);
		if (entity.getRoles() != null) {
			List<String> roles = entity.getRoles().stream().map(a -> a.getRolname().getNombre())
					.collect(Collectors.toList());
			dto.setRoles(roles);
		}
		return dto;
	}

}
