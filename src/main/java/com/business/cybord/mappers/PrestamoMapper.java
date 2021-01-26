package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;


@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PrestamoMapper {
	
	Prestamo getEntityFromDto(PrestamoDto dto);
	List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto);
	
	PrestamoDto getDtoFromEntity(Prestamo entiti);
	List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities);
	
	SaldoPrestamo getEntityFromDto(SaldoPrestamoDto dto);
	List<SaldoPrestamo> getEntitiesFromDtos(List<SaldoPrestamoDto> dtos);
	
	SaldoPrestamoDto getDtoFromEntity(SaldoPrestamo entity);
	List<SaldoPrestamoDto> getDtosFromEntities(List<SaldoPrestamoDto> entities);

	
}
