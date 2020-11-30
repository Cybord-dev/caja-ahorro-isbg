package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteSaldosDto implements Serializable {

	private static final long serialVersionUID = -8053100009213525659L;

	private String tipo;
	private String fecha;
	private BigDecimal monto;
	private String ahorrador;
	private String noEmpleado;
	private String origen;
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

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "ReporteSaldosDto [tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto + ", ahorrador=" + ahorrador
				+ ", noEmpleado=" + noEmpleado + ", origen=" + origen + ", tipoEmpleado=" + tipoEmpleado + "]";
	}

}
