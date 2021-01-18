package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private String nombreDeudor;
	private String noEmpleadoDeudor;
	private BigDecimal montoPrestamo;
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
	public String getNombreDeudor() {
		return nombreDeudor;
	}
	public void setNombreDeudor(String nombreDeudor) {
		this.nombreDeudor = nombreDeudor;
	}
	public String getNoEmpleadoDeudor() {
		return noEmpleadoDeudor;
	}
	public void setNoEmpleadoDeudor(String noEmpleadoDeudor) {
		this.noEmpleadoDeudor = noEmpleadoDeudor;
	}
	public BigDecimal getMontoPrestamo() {
		return montoPrestamo;
	}
	public void setMontoPrestamo(BigDecimal montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
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
				+ ", nombreDeudor=" + nombreDeudor + ", noEmpleadoDeudor=" + noEmpleadoDeudor + ", montoPrestamo="
				+ montoPrestamo + ", estatus=" + estatus + ", comentarios=" + comentarios + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
}
