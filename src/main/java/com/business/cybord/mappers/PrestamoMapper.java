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
	
	SaldoPrestamo getSaldoEntityFromSaldoDto(SaldoPrestamoDto dto);
	List<SaldoPrestamo> getSaldoEntitiesFromSaldoDtos(List<SaldoPrestamoDto> dtos);
	
	SaldoPrestamoDto getSaldoDtoFromEntity(SaldoPrestamo entity);
	List<SaldoPrestamoDto> getSaldoDtosFromEntities(List<SaldoPrestamoDto> entities);

	
}
