package com.business.cybord.models.dtos;

import java.util.Date;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;

public class ValidacionDto {
	private int id;
	private boolean numeroValidacion;
	private boolean status;
	private String tipoValidacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Usuario usuario;
	private Solicitud solicitud;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	@Override
	public String toString() {
		return "ValidacionDto [id=" + id + ", numeroValidacion=" + numeroValidacion + ", status=" + status
				+ ", tipoValidacion=" + tipoValidacion + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", usuario=" + usuario + ", solicitud=" + solicitud + "]";
	}
	
	
}
