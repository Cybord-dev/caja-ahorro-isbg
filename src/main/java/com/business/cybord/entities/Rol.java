package com.business.cybord.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER_ROLES")
public class Rol {
	
	@Id	
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "id_rol")
	private int idRol;
	
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name="id_usuario", insertable=false, updatable=false)
    private Usuario usuario;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rol", referencedColumnName = "id_role",  insertable=false, updatable=false)
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


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
		return "Rol [id=" + id + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", rolname=" + rolname + "]";
	}

	
	
}

