package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSolicitudDto implements Serializable {

	private static final long serialVersionUID = 4223586331591210264L;

	private Integer id;
	private String noEmpleado;
	private Integer idUsuario;
	private String nombre;
	private String tipo;
	private Date fechaEjecucion;
	private Date fechaCreacion;
	private String tipoUsuario;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoEmpleado() {
		return noEmpleado;
	}
	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserSolicitudDto [id=" + id + ", noEmpleado=" + noEmpleado + ", idUsuario=" + idUsuario + ", nombre="
				+ nombre + ", tipo=" + tipo + ", fechaEjecucion=" + fechaEjecucion + ", fechaCreacion=" + fechaCreacion
				+ ", tipoUsuario=" + tipoUsuario + ", status=" + status + "]";
	}

}