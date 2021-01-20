package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.models.entities.ValidacionAval;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ValidacionAvalMapper {
	
	ValidacionAvalDto getDtoFromEntity(ValidacionAval aceptacion);
	List<ValidacionAvalDto> getDtosFromEntities(List<ValidacionAval> aceptaciones);

}
