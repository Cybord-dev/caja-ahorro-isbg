package com.business.cybord.models.dtos;

import java.util.Date;

public class ValidiacionDto {

	private String id;
	private Integer noValidacion;
	private Integer idUser;
	private Integer status;
	private Integer tipoValidacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNoValidacion() {
		return noValidacion;
	}

	public void setNoValidacion(Integer noValidacion) {
		this.noValidacion = noValidacion;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTipoValidacion() {
		return tipoValidacion;
	}

	public void setTipoValidacion(Integer tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
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
		return "ValidiacionDto [id=" + id + ", noValidacion=" + noValidacion + ", idUser=" + idUser + ", status="
				+ status + ", tipoValidacion=" + tipoValidacion + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
