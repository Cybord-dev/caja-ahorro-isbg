package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 2329712110850660822L;

	private int id;
	private Boolean activo;
	private String nombre;
	private String email;
	private Boolean ahorrador;
	private String noEmpleado;
	private String tipoUsuario;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Map<String, String> datosUsuario;
	private List<String> roles;

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

	public Map<String, String> getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(Map<String, String> datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	
	public Boolean isAhorrador() {
		return ahorrador;
	}

	public void setAhorrador(Boolean ahorrador) {
		this.ahorrador = ahorrador;
	}

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", activo=" + activo + ", nombre=" + nombre + ", email=" + email
				+ ", noEmpleado=" + noEmpleado + ", tipoUsuario=" + tipoUsuario + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", datosUsuario=" + datosUsuario + ", roles=" + roles
				+ "]";
	}

}
