package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.ValidacionSolicitud;

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
	ValidacionSolicitud getEntityFromValidacionesDto(ValidacionSolicitudDto dto);
	ValidacionSolicitudDto getDtoFromValidacionesEntity(ValidacionSolicitud dto);
	List<ValidacionSolicitudDto> validacionDtoToValidacion(List<ValidacionSolicitud>dto);
}
