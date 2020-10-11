package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.Validacion;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SolicitudMapper {
	

	@Mapping(target="idUsuario",source="usuario.id")
	@Mapping(target="atributos",expression="java(dto.getAttributesAsMap())")
	SolicitudDto getDtoFromSolicitudEntity(Solicitud dto);
	List<SolicitudDto> solicitudDtoToSolicitud(List<Solicitud> dto);
	
	@Mapping(target="atributos",expression="java(dto.getAttributesAsList())")
	Solicitud getEntityFromSolicitudDto(SolicitudDto dto);
	
	
	//Atributos
	AtributoSolicitud getEntityFromAtributoSolicitudDto(AtributoSolicitudDto dto);
	AtributoSolicitudDto getDtoFromAtributoSolicitudEntity(AtributoSolicitud dto);
	List<AtributoSolicitudDto> atributoSolicitudDtoToAtributoSolicitud(List<AtributoSolicitud> entity);
	List<AtributoSolicitud> getEntitiesFromAtributosSolicitudDto(List<AtributoSolicitudDto> dtos);
	
	//Validaciones
	Validacion getEntityFromValidacionesDto(ValidacionDto dto);
	ValidacionDto getDtoFromValidacionesEntity(Validacion dto);
	List<ValidacionDto> validacionDtoToValidacion(List<Validacion>dto);
}
