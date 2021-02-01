package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.SaldoPrestamoDto;

import com.business.cybord.models.entities.SaldoPrestamo;


@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaldoPrestamoMapper {
	
	SaldoPrestamo getEntityFromDto(SaldoPrestamoDto dto);
	List<SaldoPrestamo> getEntitysFromDtos(List<SaldoPrestamoDto> dto);
	
	SaldoPrestamoDto getDtoFromEntity(SaldoPrestamo entity);
	List<SaldoPrestamoDto> getDtosFromEntity(List<SaldoPrestamo> entities);

}
