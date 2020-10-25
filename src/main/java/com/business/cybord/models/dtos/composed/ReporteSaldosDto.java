package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReporteSaldosDto implements Serializable {

	private static final long serialVersionUID = -8053100009213525659L;

	private String tipo;
	private String fecha;
	private BigDecimal monto;
	private String ahorrador;
	private Integer noEmpleado;
	private String tipoEmpleado;

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

	public String getAhorrador() {
		return ahorrador;
	}

	public void setAhorrador(String ahorrador) {
		this.ahorrador = ahorrador;
	}

	public Integer getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(Integer noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
		return "ReporteSaldosDto [tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + ", ahorrador=" + ahorrador
				+ ", noEmpleado=" + noEmpleado + ", tipoEmpleado=" + tipoEmpleado + "]";
	}

}
