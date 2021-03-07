package com.business.cybord.models.dtos.reports;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteAhorroDto implements Serializable {

	private static final long serialVersionUID = 1901090365823000293L;
	private Integer idUsuario;
	private String tipoUsuario;
	private String noEmpleado;
	private String nombre;
	private BigDecimal total;
	private BigDecimal ahorro;
	private BigDecimal ajuste;
	private BigDecimal interes;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getAhorro() {
		return ahorro;
	}

	public void setAhorro(BigDecimal ahorro) {
		this.ahorro = ahorro;
	}

	public BigDecimal getAjuste() {
		return ajuste;
	}

	public void setAjuste(BigDecimal ajuste) {
		this.ajuste = ajuste;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	@Override
	public String toString() {
		return "ReporteAhorroDto [noEmpleado=" + noEmpleado + ", nombre=" + nombre + ", total=" + total + ", ahorro="
				+ ahorro + ", ajuste=" + ajuste + ", interes=" + interes + "]";
	}

}
