package com.business.cybord.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;
import com.business.cybord.models.entities.Solicitud;

public class PrestamoMapperDecorator implements PrestamoMapper {

	@Autowired
	private PrestamoMapper delegate;

	@Override
	public Prestamo getEntityFromDto(PrestamoDto dto) {
		Prestamo prestamo = delegate.getEntityFromDto(dto);
		return prestamo;
	}

	@Override
	public List<Prestamo> getEntitysFromDtos(List<PrestamoDto> dto) {
		List<Prestamo> prestamod = delegate.getEntitysFromDtos(dto);
		return prestamod;
	}

	@Override
	public PrestamoDto getDtoFromEntity(Prestamo dto) {
		PrestamoDto prestamo = delegate.getDtoFromEntity(dto);
		SolicitudDto solicitudDto= new SolicitudDto();
		Solicitud solicitud =dto.getSolicitud();
		solicitudDto.setId(solicitud.getId());
		solicitudDto.setFechaActualizacion(solicitud.getFechaActualizacion());
		solicitudDto.setFechaCreacion(solicitud.getFechaCreacion());
		solicitudDto.setFechaEjecucion(solicitud.getFechaEjecucion());
		solicitudDto.setIdUsuario(solicitud.getUsuario().getId());
		solicitudDto.setStatus(solicitud.getStatus());
		solicitudDto.setStatusDetalle(solicitud.getStatusDetalle());
		solicitudDto.setTipo(solicitud.getTipo());
		solicitudDto.setAtributos(solicitud.getAttributesAsMap());
		prestamo.setSolicitud(solicitudDto);
		return prestamo;
	}

	@Override
	public List<PrestamoDto> getDtosFromEntity(List<Prestamo> entities) {
		List<PrestamoDto> prestamos = delegate.getDtosFromEntity(entities);
		return prestamos;
	}

	@Override
	public SaldoPrestamo getSaldoEntityFromSaldoDto(SaldoPrestamoDto dto) {
		SaldoPrestamo saldoPrestamo = delegate.getSaldoEntityFromSaldoDto(dto);
		return saldoPrestamo;
	}

	@Override
	public List<SaldoPrestamo> getSaldoEntitiesFromSaldoDtos(List<SaldoPrestamoDto> dtos) {
		List<SaldoPrestamo> prestamos = delegate.getSaldoEntitiesFromSaldoDtos(dtos);
		return prestamos;
	}

	@Override
	public SaldoPrestamoDto getSaldoDtoFromEntity(SaldoPrestamo saldoPrestamo) {
		SaldoPrestamoDto saldoPrestamoDto = delegate.getSaldoDtoFromEntity(saldoPrestamo);
		return saldoPrestamoDto;
	}

	@Override
	public List<SaldoPrestamoDto> getSaldoDtosFromEntities(List<SaldoPrestamoDto> entities) {
		List<SaldoPrestamoDto> saldoPrestamoDtos = delegate.getSaldoDtosFromEntities(entities);
		return saldoPrestamoDtos;
	}

}
