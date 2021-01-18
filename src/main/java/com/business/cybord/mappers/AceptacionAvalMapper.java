package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.AceptacionAvalDto;
import com.business.cybord.models.entities.AceptacionAval;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AceptacionAvalMapper {
	
	AceptacionAvalDto getDtoFromEntity(AceptacionAval aceptacion);
	List<AceptacionAvalDto> getDtosFromEntities(List<AceptacionAval> aceptaciones);

}
