package com.business.cybord.models.dtos.composed;

import java.util.Date;

public class UserSolicitudDto {

	private int idSolicitud;
	private int idUser;
	private String nombre;
	private String tipo;
	private Date fechaSolicitud;
	private String tipoUsuario;
	private String statusSolicitud;

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getStatusSolicitud() {
		return statusSolicitud;
	}

	public void setStatusSolicitud(String statusSolicitud) {
		this.statusSolicitud = statusSolicitud;
	}

}
