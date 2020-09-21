package com.business.cybord.mappers;

import org.mapstruct.Mapper;

import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.models.dtos.DatosUsuarioDto;

@Mapper(componentModel = "spring")
public interface DatoUsuarioMapper {
	
	DatosUsuario getDatosEntityFromDatosUsuarioDto(DatosUsuarioDto dto);
	
	DatosUsuarioDto getDtoFromDatosusuarioEntity(DatosUsuario entiti);
	
}
