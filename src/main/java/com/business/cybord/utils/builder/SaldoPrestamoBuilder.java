package com.business.cybord.utils.builder;

import java.math.BigDecimal;

import com.business.cybord.models.entities.SaldoPrestamo;

public class SaldoPrestamoBuilder extends AbstractBuilder<SaldoPrestamo> {

	public SaldoPrestamoBuilder() {
		super(new SaldoPrestamo());
	}
	
	public SaldoPrestamoBuilder setIdPrestamo(int idPrestamo) {
		instance.setIdPrestamo(idPrestamo);
		return this;
	}
	
	public SaldoPrestamoBuilder setTipo(String tipo) {
		instance.setTipo(tipo);
		return this;
	}
	
	public SaldoPrestamoBuilder setMonto(Double monto) {
		instance.setMonto(new BigDecimal(monto));
		return this;
	}
	
	public SaldoPrestamoBuilder setValidado(Boolean validado) {
		instance.setValidado(validado);
		return this;
	}
	
	public SaldoPrestamoBuilder setOrigen(String origen) {
		instance.setOrigen(origen);
		return this;
	}
	
		
	
	

}
