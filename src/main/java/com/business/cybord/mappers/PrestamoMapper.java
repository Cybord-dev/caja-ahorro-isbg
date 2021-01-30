package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;



@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrestamoMapper {
	
	@Mapping(target="solicitud.atributos",ignore = true)
	Prestamo getEntityFromDto(PrestamoDto dto);
	List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto);
	
	@Mapping(target="solicitud.atributos", ignore = true)
	PrestamoDto getDtoFromEntity(Prestamo dto);
	List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities);
	
	SaldoPrestamo getSaldoEntityFromSaldoDto(SaldoPrestamoDto dto);
	List<SaldoPrestamo> getSaldoEntitiesFromSaldoDtos(List<SaldoPrestamoDto> dtos);
	
	SaldoPrestamoDto getSaldoDtoFromEntity(SaldoPrestamo saldoPrestamo);
	List<SaldoPrestamoDto> getSaldoDtosFromEntities(List<SaldoPrestamoDto> entities);
	
	
	

	
}
