package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConciliaSaldoDto implements Serializable {

	private static final long serialVersionUID = 6120525882244348410L;
	private Integer idUsuario;
	private String noEmpleado;
	private String nombre;
	private BigDecimal saldo;
	private Boolean validado;
	private String observaciones;

	public ConciliaSaldoDto() {
		super();
	}

	public ConciliaSaldoDto(Integer idUsuario, String noEmpleado, String nombre, BigDecimal saldo, Boolean validado,
			String observaciones) {
		super();
		this.idUsuario = idUsuario;
		this.noEmpleado = noEmpleado;
		this.nombre = nombre;
		this.saldo = saldo;
		this.validado = validado;
		this.observaciones = observaciones;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
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
