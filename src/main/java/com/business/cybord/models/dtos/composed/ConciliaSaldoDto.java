package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConciliaSaldoDto implements Serializable{

	private static final long serialVersionUID = 6120525882244348410L;
	private int idUsuario;
	private String noEmpleado;
	private String nombre;
	private BigDecimal saldo;
	private Boolean validado;
	private String observaciones;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	@Override
	public String toString() {
		return "ConciliaSaldoDto [idUsuario=" + idUsuario + ", noEmpleado=" + noEmpleado + ", nombre=" + nombre
				+ ", saldo=" + saldo + ", validado=" + validado + ", observaciones=" + observaciones + "]";
	}

}
