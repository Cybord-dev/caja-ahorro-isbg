package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto implements Serializable {

	private static final long serialVersionUID = 618557570424591531L;
	private int id;
	private Boolean activo;
	private String noEmpleado;
	private String nombre;
	private String email;
	private String urlImagenPerfil;
	private List<String> roles;
	private List<MenuItem> menu;

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
  
	public String getNoEmpleado() {
		return noEmpleado;
	}
	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
	}

	public String getUrlImagenPerfil() {
		return urlImagenPerfil;
	}

	public void setUrlImagenPerfil(String urlImagenPerfil) {
		this.urlImagenPerfil = urlImagenPerfil;
	}

	@Override
	public String toString() {
		return "UserInfoDto [id=" + id + ", activo=" + activo + ", noEmpleado=" + noEmpleado + ", nombre=" + nombre
				+ ", email=" + email + ", urlImagenPerfil=" + urlImagenPerfil + ", roles=" + roles + ", menu=" + menu
				+ "]";
	}
}
