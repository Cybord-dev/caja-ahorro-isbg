package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReporteSaldosDto implements Serializable {

	private static final long serialVersionUID = -8053100009213525659L;

	private String tipo;
	private String fecha;
	private BigDecimal monto;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "ReporteSaldosDto [tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

}
