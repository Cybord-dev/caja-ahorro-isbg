package com.business.cybord.mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuariosDto;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {
	
	Usuario getEntityFromUserDto(UsuariosDto dto);
	UsuariosDto getDtoFromUserEntity(Usuario dto);
	List<UsuariosDto> getUsuariosDtoFromEntities(List<Usuario> entities);
	
	// DatosUsuario
	DatosUsuario getDatosEntityFromDatosUsuarioDto(DatosUsuarioDto dto);
	DatosUsuarioDto getDtoFromDatosusuarioEntity(DatosUsuario entiti);

	//Solicitudes
	Solicitud getEntityFromSolicitudDto(SolicitudDto dto);
	SolicitudDto getDtoFromSolicitudEntity(Solicitud dto);
}
