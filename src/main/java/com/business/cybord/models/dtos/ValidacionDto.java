package com.business.cybord.models.dtos;

import java.util.Date;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;

public class ValidacionDto {
	private int id;
	private Integer idSolicitud;
	private Integer idUsuario;
	private boolean numeroValidacion;
	private boolean status;
	private String tipoValidacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isNumeroValidacion() {
		return numeroValidacion;
	}
	public void setNumeroValidacion(boolean numeroValidacion) {
		this.numeroValidacion = numeroValidacion;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getTipoValidacion() {
		return tipoValidacion;
	}
	public void setTipoValidacion(String tipoValidacion) {
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
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	
	
}
