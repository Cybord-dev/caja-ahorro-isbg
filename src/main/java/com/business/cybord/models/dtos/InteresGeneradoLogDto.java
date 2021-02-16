package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteresGeneradoLogDto implements Serializable {

	private static final long serialVersionUID = -3179811973816672988L;

	private int id;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date fechaEjecucion;
	private String tipoUsuario;
	private BigDecimal saldoAhorro;
	private BigDecimal interesGenerado;
	private BigDecimal porcentajeInteres;
	private BigDecimal interesRepartido;
	private BigDecimal interesCaja;
	
	public InteresGeneradoLogDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public BigDecimal getSaldoAhorro() {
		return saldoAhorro;
	}

	public void setSaldoAhorro(BigDecimal saldoAhorro) {
		this.saldoAhorro = saldoAhorro;
	}

	public BigDecimal getInteresGenerado() {
		return interesGenerado;
	}

	public void setInteresGenerado(BigDecimal interesGenerado) {
		this.interesGenerado = interesGenerado;
	}

	public BigDecimal getPorcentajeInteres() {
		return porcentajeInteres;
	}

	public void setPorcentajeInteres(BigDecimal porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
	}

	public BigDecimal getInteresRepartido() {
		return interesRepartido;
	}

	public void setInteresRepartido(BigDecimal interesRepartido) {
		this.interesRepartido = interesRepartido;
	}

	public BigDecimal getInteresCaja() {
		return interesCaja;
	}

	public void setInteresCaja(BigDecimal interesCaja) {
		this.interesCaja = interesCaja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InteresGeneradoLogDto [id=" + id + ", fechaEjecucion=" + fechaEjecucion + ", tipoUsuario=" + tipoUsuario
				+ ", saldoAhorro=" + saldoAhorro + ", interesGenerado=" + interesGenerado + ", porcentajeInteres="
				+ porcentajeInteres + ", interesRepartido=" + interesRepartido + ", interesCaja=" + interesCaja + "]";
	}
	
	
	
}
