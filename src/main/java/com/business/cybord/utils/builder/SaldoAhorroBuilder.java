package com.business.cybord.utils.builder;

import java.math.BigDecimal;

import com.business.cybord.models.entities.SaldoAhorro;

public class SaldoAhorroBuilder extends AbstractBuilder<SaldoAhorro>{

	public SaldoAhorroBuilder() {
		super(new SaldoAhorro());
		instance.setValidado(false);
		
	}
	
	public SaldoAhorroBuilder setIdUsuario(Integer idUsuario) {
		instance.setIdUsuario(idUsuario);
		return this;
	}
	
	public SaldoAhorroBuilder setTipo(String tipo) {
		instance.setTipo(tipo);
		return this;
	}
	
	public SaldoAhorroBuilder setMonto(BigDecimal monto) {
		instance.setMonto(monto);
		return this;
	}
	
	public SaldoAhorroBuilder setValidado(Boolean validado) {
		instance.setValidado(validado);
		return this;
	}
	
	public SaldoAhorroBuilder setOrigen (String origen) {
		instance.setOrigen(origen);
		return this;
	}
	
	public SaldoAhorroBuilder setObservaciones(String observaciones) {
		instance.setObservaciones(observaciones);
		return this;
	}
	
	
}
