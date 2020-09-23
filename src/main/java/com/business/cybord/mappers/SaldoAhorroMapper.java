package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import com.business.cybord.entities.SaldoAhorro;
import com.business.cybord.models.dtos.SaldoAhorroDto;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaldoAhorroMapper {
	
	SaldoAhorro getEntityFromDto(SaldoAhorroDto dto);
	
	SaldoAhorroDto getDtoFromEntity(SaldoAhorro entiti);

	List<SaldoAhorroDto> getDtosFromEntity(List<SaldoAhorro> entities);

	List<SaldoAhorro> getEntitysFromDtos(List<SaldoAhorroDto> dto);

}
