package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.UserInfoDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.entities.Usuario;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(UsuarioMapperDecorator.class)
public interface UsuariosMapper {

	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "datosUsuario", ignore = true)
	Usuario getEntityFromUserDto(UsuarioDto dto);

	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "datosUsuario", ignore = true)
	UsuarioDto getDtoFromUserEntity(Usuario entity);
	List<UsuarioDto> getDtosFromEntities(List<Usuario> entities);

	@Mapping(target = "roles", ignore = true)
	UserInfoDto getUserInfoFromUsuario(Usuario entity);

}
