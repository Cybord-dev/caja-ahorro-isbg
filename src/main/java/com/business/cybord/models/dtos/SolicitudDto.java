package com.business.cybord.models.dtos;

import java.util.Date;
import java.util.List;

public class SolicitudDto {

	private Integer id;
	private Integer idUSer;
	private String tipoSolicitud;
	private String status;
	private String currentValidation;
	private String statusDetalle;
	private Date fechaEjecucion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<ValidiacionDto> validaciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUSer() {
		return idUSer;
	}

	public void setIdUSer(Integer idUSer) {
		this.idUSer = idUSer;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDetalle() {
		return statusDetalle;
	}

	public void setStatusDetalle(String statusDetalle) {
		this.statusDetalle = statusDetalle;
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

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public List<ValidiacionDto> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(List<ValidiacionDto> validaciones) {
		this.validaciones = validaciones;
	}

	public String getCurrentValidation() {
		return currentValidation;
	}

	public void setCurrentValidation(String currentValidation) {
		this.currentValidation = currentValidation;
	}

	@Override
	public String toString() {
		return "SolicitudDto [id=" + id + ", idUSer=" + idUSer + ", tipoSolicitud=" + tipoSolicitud + ", status="
				+ status + ", currentValidation=" + currentValidation + ", statusDetalle=" + statusDetalle
				+ ", fechaEjecucion=" + fechaEjecucion + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", validaciones=" + validaciones + "]";
	}

}
