package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AceptacionAvalDto implements Serializable {

	private static final long serialVersionUID = -2856938202769076703L;

	private int id;
	private int idSolicitud;
	private String noEmpleadoAval;
	private String nombreAval;
	private String emailAval;
	private String estatus;
	private String comentarios;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getNoEmpleadoAval() {
		return noEmpleadoAval;
	}
	public void setNoEmpleadoAval(String noEmpleadoAval) {
		this.noEmpleadoAval = noEmpleadoAval;
	}
	public String getNombreAval() {
		return nombreAval;
	}
	public void setNombreAval(String nombreAval) {
		this.nombreAval = nombreAval;
	}
	public String getEmailAval() {
		return emailAval;
	}
	public void setEmailAval(String emailAval) {
		this.emailAval = emailAval;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
		return "AceptacionAvalDto [id=" + id + ", idSolicitud=" + idSolicitud + ", noEmpleadoAval=" + noEmpleadoAval
				+ ", nombreAval=" + nombreAval + ", emailAval=" + emailAval + ", estatus=" + estatus + ", comentarios="
				+ comentarios + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
