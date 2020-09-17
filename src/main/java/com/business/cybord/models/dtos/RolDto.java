package com.business.cybord.models.dtos;

import com.business.cybord.entities.RolCat;
import com.business.cybord.entities.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolDto {

	
	
	private int id;
	private int idUsuario;
	private int idRol;
//    private Usuario usuario;
	private RolCat rolname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
//	public Usuario getUsuario() {
//		return usuario;
//	}
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	public RolCat getRolname() {
		return rolname;
	}
	public void setRolname(RolCat rolname) {
		this.rolname = rolname;
	}
	
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	@Override
	public String toString() {
		return "RolDto [id=" + id + ", idUsuario=" + idUsuario + ", rolname=" + rolname + "]";
	}
	
	

}
