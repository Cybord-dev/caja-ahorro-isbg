package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.util.Date;

public class UserSolicitudDto implements Serializable {

	private static final long serialVersionUID = 4223586331591210264L;
	
	private int id;
	private int noEmpleado;
	private int idUsuario;
	private String nombre;
	private String tipo;
	private Date fechaEjecucion;
	private Date fechaCreacion;
	private String tipoUsuario;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoEmpleado() {
		return noEmpleado;
	}
	public void setNoEmpleado(int noEmpleado) {
		this.noEmpleado = noEmpleado;
	}
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
