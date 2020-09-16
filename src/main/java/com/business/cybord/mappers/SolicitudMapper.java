package com.business.cybord.mappers;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Validacion;
import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {
	SolicitudDto getDtoFromSolicitudEntity(Solicitud dto);
	Solicitud getEntityFromSolicitudDto(SolicitudDto dto);
	List<SolicitudDto> SolicitudDtoToSolicitud(Stream<Solicitud> dto);
	
	//Atributos
	AtributoSolicitud getEntityFromAtributoSolicitudDto(AtributoSolicitudDto dto);
	AtributoSolicitudDto getDtoFromAtributoSolicitudEntity(AtributoSolicitud dto);
	
	//Validaciones
	Validacion getEntityFromValidacionesDto(ValidacionDto dto);
	ValidacionDto getDtoFromValidacionesEntity(Validacion dto);
	
}
