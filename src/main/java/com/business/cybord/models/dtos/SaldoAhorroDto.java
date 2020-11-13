package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.business.cybord.models.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaldoAhorroDto implements Serializable {

	private static final long serialVersionUID = -4224063396732828090L;
	private int id;
	private int idUsuario;
	private String tipo;
	private BigDecimal monto;
	private Boolean validado;
	private String origen;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date fechaCreacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date fechaActualizacion;

	public SaldoAhorroDto(int idUsuario, String tipo, BigDecimal monto, Boolean validado) {
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.monto = monto;
		this.validado = validado;
	}

	public SaldoAhorroDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "SaldoAhorroDto [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", monto=" + monto
				+ ", validado=" + validado + ", origen=" + origen + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
