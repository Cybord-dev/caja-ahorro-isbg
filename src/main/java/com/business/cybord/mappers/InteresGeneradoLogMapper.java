package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.InteresGeneradoLogDto;
import com.business.cybord.models.entities.InteresGeneradoLog;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InteresGeneradoLogMapper {

	InteresGeneradoLog getEntityFromDto(InteresGeneradoLogDto dto);
	
	InteresGeneradoLogDto getDtoFromEntity(InteresGeneradoLog entity);


	List<InteresGeneradoLogDto> getDtosFromEntity(List<InteresGeneradoLog> entities);

	List<InteresGeneradoLog> getEntitysFromDtos(List<InteresGeneradoLogDto> dto);
	
}
