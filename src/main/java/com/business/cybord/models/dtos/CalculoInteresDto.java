package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculoInteresDto implements Serializable {

	
	private static final long serialVersionUID = 1508270793685815369L;
	
	private BigDecimal porcentajeInteresDelPeriodo;
	private BigDecimal interesDelPerido;
	private BigDecimal interesRetenido;
	private BigDecimal saldoAhorroTotal;
	private BigDecimal saldoPrestamoInteresTotal;
	
	public BigDecimal getInteresDelPerido() {
		return interesDelPerido;
	}
	
	public void setInteresDelPerido(BigDecimal interesDelPerido) {
		this.interesDelPerido = interesDelPerido;
	}
	
	public BigDecimal getInteresRetenido() {
		return interesRetenido;
	}
	
	public void setInteresRetenido(BigDecimal interesRetenido) {
		this.interesRetenido = interesRetenido;
	}
	
	public BigDecimal getSaldoAhorroTotal() {
		return saldoAhorroTotal;
	}
	
	public void setSaldoAhorroTotal(BigDecimal saldoAhorroTotal) {
		this.saldoAhorroTotal = saldoAhorroTotal;
	}
	
	public BigDecimal getSaldoPrestamoInteresTotal() {
		return saldoPrestamoInteresTotal;
	}
	
	public void setSaldoPrestamoInteresTotal(BigDecimal saldoPrestamoInteresTotal) {
		this.saldoPrestamoInteresTotal = saldoPrestamoInteresTotal;
	}
	

	public BigDecimal getPorcentajeInteresDelPeriodo() {
		return porcentajeInteresDelPeriodo;
	}

	public void setPorcentajeInteresDelPeriodo(BigDecimal porcentajeInteresDelPeriodo) {
		this.porcentajeInteresDelPeriodo = porcentajeInteresDelPeriodo;
	}

	@Override
	public String toString() {
		return "CalculoInteresDto [porcentajeInteresDelPeriodo=" + porcentajeInteresDelPeriodo + ", interesDelPerido="
				+ interesDelPerido + ", interesRetenido=" + interesRetenido + ", saldoAhorroTotal=" + saldoAhorroTotal
				+ ", saldoPrestamoInteresTotal=" + saldoPrestamoInteresTotal + "]";
	}


	
	
	
	

}
