package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAhorroDto implements Serializable {
	private static final long serialVersionUID = 2586151288660410350L;
	private int id;
	private Boolean activo;
	private String nombre;
	private String email;
	private Boolean ahorrador;
	private String noEmpleado;
	private String tipoUsuario;
	private String montoAhorro;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAhorrador() {
		return ahorrador;
	}

	public void setAhorrador(Boolean ahorrador) {
		this.ahorrador = ahorrador;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getMontoAhorro() {
		return montoAhorro;
	}

	public void setMontoAhorro(String montoAhorro) {
		this.montoAhorro = montoAhorro;
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

	@Override
	public String toString() {
		return "UserAhorroDto [id=" + id + ", activo=" + activo + ", nombre=" + nombre + ", email=" + email
				+ ", ahorrador=" + ahorrador + ", noEmpleado=" + noEmpleado + ", tipoUsuario=" + tipoUsuario
				+ ", montoAhorro=" + montoAhorro + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + "]";
	}

}
