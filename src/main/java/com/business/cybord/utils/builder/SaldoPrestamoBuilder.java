package com.business.cybord.utils.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.business.cybord.models.dtos.SaldoPrestamoDto;

public class SaldoPrestamoBuilder extends AbstractBuilder<SaldoPrestamoDto> {

	public SaldoPrestamoBuilder() {
		super(new SaldoPrestamoDto());
	}

	public SaldoPrestamoBuilder setId(Integer id) {
		instance.setId(id);
		;
		return this;
	}

	public SaldoPrestamoBuilder setIdPrestamo(Integer idPrestamo) {
		instance.setIdPrestamo(idPrestamo);
		return this;
	}

	public SaldoPrestamoBuilder setIdUsuario(Integer idUsuario) {
		instance.setIdUsuario(idUsuario);
		return this;
	}

	public SaldoPrestamoBuilder setMontoPrestamo(BigDecimal montoPrestamo) {
		instance.setMontoPrestamo(montoPrestamo);
		return this;
	}

	public SaldoPrestamoBuilder setSaldoPendiente(BigDecimal saldoPendiente) {
		instance.setSaldoPendiente(saldoPendiente);
		return this;
	}

	public SaldoPrestamoBuilder setEstatus(String estatus) {
		instance.setEstatus(estatus);
		return this;
	}

	public SaldoPrestamoBuilder setNoQuincenas(Integer noQuincenas) {
		instance.setNoQuincenas(noQuincenas);
		return this;
	}

	public SaldoPrestamoBuilder setTasaInteres(BigDecimal tasaInteres) {
		instance.setTasaInteres(tasaInteres);
		return this;
	}

	public SaldoPrestamoBuilder setTipo(String tipo) {
		instance.setTipo(tipo);
		return this;
	}

	public SaldoPrestamoBuilder setOrigen(String origen) {
		instance.setOrigen(origen);
		return this;
	}

	public SaldoPrestamoBuilder setMonto(BigDecimal monto) {
		instance.setMonto(monto);
		return this;
	}

	public SaldoPrestamoBuilder setValidado(Boolean validado) {
		instance.setValidado(validado);
		return this;
	}

	public SaldoPrestamoBuilder setFechaCreacion(LocalDate fechaCreacion) {
		instance.setFechaCreacion(fechaCreacion);
		return this;
	}

	public SaldoPrestamoBuilder setFechaActualizacion(LocalDateTime fechaActualizacion) {
		instance.setFechaActualizacion(fechaActualizacion);
		return this;
	}

}
