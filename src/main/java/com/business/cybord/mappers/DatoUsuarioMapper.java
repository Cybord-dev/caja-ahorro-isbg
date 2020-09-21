package com.business.cybord.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.models.dtos.DatosUsuarioDto;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DatoUsuarioMapper {
	
	DatosUsuario getDatosEntityFromDatosUsuarioDto(DatosUsuarioDto dto);
	
	DatosUsuarioDto getDtoFromDatosusuarioEntity(DatosUsuario entiti);
	
}
