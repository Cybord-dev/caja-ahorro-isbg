package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
@DecoratedWith(PrestamoMapperDecorator.class)
public interface PrestamoMapper {

	@Mapping(target = "solicitud", ignore = true)
	Prestamo getEntityFromDto(PrestamoDto dto);
	List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto);

	@Mapping(target = "solicitud", ignore = true)
	PrestamoDto getDtoFromEntity(Prestamo entity);
	List<PrestamoDto> getDtosFromEntities(List<Prestamo> entities);

	List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities);

	SaldoPrestamo getSaldoEntityFromSaldoDto(SaldoPrestamoDto dto);

	List<SaldoPrestamo> getSaldoEntitiesFromSaldoDtos(List<SaldoPrestamoDto> dtos);

	SaldoPrestamoDto getSaldoDtoFromEntity(SaldoPrestamo saldoPrestamo);

	List<SaldoPrestamoDto> getSaldoDtosFromEntities(List<SaldoPrestamoDto> entities);

}
