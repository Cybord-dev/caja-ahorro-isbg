package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.util.Date;

public class UserValidacionSolicitudDto implements Serializable {

	private static final long serialVersionUID = 4223586331591210264L;

	private int id;
	private String validador;
	private Date fechaCreacion;
	private String aprobada;
	private String detalle;
	private String area;

	private int noEmpleado;
	private int idUsuario;
	private String nombre;
	private String tipoUsuario;

	private int idSolicitud;
	private String tipo;
	private Date fechaEjecucion;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValidador() {
		return validador;
	}

	public void setValidador(String validador) {
		this.validador = validador;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getAprobada() {
		return aprobada;
	}

	public void setAprobada(String aprobada) {
		this.aprobada = aprobada;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "UserValidacionSolicitudDto [id=" + id + ", validador=" + validador + ", fechaCreacion=" + fechaCreacion
				+ ", aprobada=" + aprobada + ", detalle=" + detalle + ", area=" + area + ", noEmpleado=" + noEmpleado
				+ ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", tipoUsuario=" + tipoUsuario + ", idSolicitud="
				+ idSolicitud + ", tipo=" + tipo + ", fechaEjecucion=" + fechaEjecucion + ", status=" + status + "]";
	}

}
