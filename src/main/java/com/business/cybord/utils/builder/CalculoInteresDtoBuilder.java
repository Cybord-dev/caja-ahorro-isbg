package com.business.cybord.utils.builder;

import java.math.BigDecimal;

import com.business.cybord.models.dtos.CalculoInteresDto;

public class CalculoInteresDtoBuilder extends AbstractBuilder<CalculoInteresDto> {

	public CalculoInteresDtoBuilder() {
		super(new CalculoInteresDto());
		
	}
	
	public CalculoInteresDtoBuilder setInteresDelPeriodo(BigDecimal interesDelPeriodo) {
		instance.setInteresDelPerido(interesDelPeriodo);
		return this;
	}
	
	public CalculoInteresDtoBuilder setInteresRetenido(BigDecimal interesRetenido) {
		instance.setInteresRetenido(interesRetenido);
		return this;
	}
	
	public CalculoInteresDtoBuilder setSaldoAhorroTotal(BigDecimal saldoAhorroTotal) {
		instance.setSaldoAhorroTotal(saldoAhorroTotal);
		return this;
	}
	
	public CalculoInteresDtoBuilder setSaldoPrestamoInteresTotal(BigDecimal saldoPrestamoInteresTotal) {
		instance.setSaldoPrestamoInteresTotal(saldoPrestamoInteresTotal);
		return this;	
	}
	

	public CalculoInteresDtoBuilder setPorcentajeInteresDelPeriodo(BigDecimal porcentajeInteresDelPeriodo) {
		instance.setPorcentajeInteresDelPeriodo(porcentajeInteresDelPeriodo);
		return this;
	}


}
