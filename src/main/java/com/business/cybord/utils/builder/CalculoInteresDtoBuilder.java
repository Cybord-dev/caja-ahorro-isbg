package com.business.cybord.utils.builder;

import java.math.BigDecimal;
import java.util.List;

import com.business.cybord.models.dtos.CalculoInteresDto;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;

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
	
	public CalculoInteresDtoBuilder setSaldoAhorro(List<SaldoAhorroDto> saldoAhorro) {
		instance.setSaldoAhorro(saldoAhorro);
		return this;
	}
	
	public CalculoInteresDtoBuilder setSaldoPrestamoInteres(List<SaldoPrestamoDto> saldoPrestamoInteres) {
		instance.setSaldoPrestamoInteres(saldoPrestamoInteres);
		return this;
	}

	public CalculoInteresDtoBuilder setPorcentajeInteresDelPeriodo(BigDecimal porcentajeInteresDelPeriodo) {
		instance.setPorcentajeInteresDelPeriodo(porcentajeInteresDelPeriodo);
		return this;
	}


}
