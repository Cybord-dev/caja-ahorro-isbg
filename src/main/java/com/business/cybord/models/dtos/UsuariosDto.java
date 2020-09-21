package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.entities.Rol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuariosDto implements Serializable {

	private static final long serialVersionUID = 2329712110850660822L;

	private int id;
	private Boolean activo;
	private String nombre;
	private String email;
	private String tipoUsuario;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<DatosUsuario> datosUsuario;
	private List<Rol> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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

	public List<DatosUsuario> getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(List<DatosUsuario> datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UsuariosDto [id=" + id + ", activo=" + activo + ", nombre=" + nombre + ", email=" + email
				+ ", tipoUsuario=" + tipoUsuario + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", datosUsuario=" + datosUsuario + "]";
	}

}
