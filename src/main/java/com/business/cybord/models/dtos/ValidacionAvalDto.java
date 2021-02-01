package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidacionAvalDto implements Serializable {

	private static final long serialVersionUID = -2856938202769076703L;

	private int id;
	private int idSolicitud;
	private int idUsuarioAval;
	private String nombreAval;
	private String nombreDeudor;
	private int idUsuarioDeudor;
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

	public String getNombreAval() {
		return nombreAval;
	}

	public void setNombreAval(String nombreAval) {
		this.nombreAval = nombreAval;
	}

	public String getNombreDeudor() {
		return nombreDeudor;
	}

	public void setNombreDeudor(String nombreDeudor) {
		this.nombreDeudor = nombreDeudor;
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

	public int getIdUsuarioAval() {
		return idUsuarioAval;
	}

	public void setIdUsuarioAval(int idUsuarioAval) {
		this.idUsuarioAval = idUsuarioAval;
	}

	public int getIdUsuarioDeudor() {
		return idUsuarioDeudor;
	}

	public void setIdUsuarioDeudor(int idUsuarioDeudor) {
		this.idUsuarioDeudor = idUsuarioDeudor;
	}

	@Override
	public String toString() {
		return "ValidacionAvalDto [id=" + id + ", idSolicitud=" + idSolicitud + ", idUsuarioAval=" + idUsuarioAval
				+ ", nombreAval=" + nombreAval + ", nombreDeudor=" + nombreDeudor + ", idUsuarioDeudor="
				+ idUsuarioDeudor + ", montoPrestamo=" + montoPrestamo + ", estatus=" + estatus + ", comentarios="
				+ comentarios + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
