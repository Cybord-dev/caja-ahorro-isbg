package com.business.cybord.models.dtos.composed;

import java.math.BigDecimal;

public class ConciliaSaldoDto {

	private int idUsuario;
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

	@Override
	public String toString() {
		return "ConciliaSaldoDto [idUsuario=" + idUsuario + ", nombre=" + nombre + ", saldo=" + saldo + ", validado="
				+ validado + ", observaciones=" + observaciones + "]";
	}

}
