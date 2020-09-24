package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.Validacion;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SolicitudMapper {
	

	SolicitudDto getDtoFromSolicitudEntity(Solicitud dto);
	Solicitud getEntityFromSolicitudDto(SolicitudDto dto);
	List<SolicitudDto> solicitudDtoToSolicitud(List<Solicitud> dto);
	
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
