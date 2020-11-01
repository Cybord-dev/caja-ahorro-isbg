package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaldoAhorroCajaDto implements Serializable {

	private static final long serialVersionUID = 5507372535645454225L;
	private BigDecimal monto;
	private String mes;
	private String tipo;

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "SaldoAhorroCajaDto [monto=" + monto + ", mes=" + mes + ", tipo=" + tipo + "]";
	}

}
