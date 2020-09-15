package com.business.cybord.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER_ROLES")
public class Rol {
	
	@Id	
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_user")
	private int idUsuario;
	

	@Column(name = "id_rol")
	private int idRol;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

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

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", idUsuario=" + idUsuario + ", idRol=" + idRol + ", usuario=" + usuario + "]";
	}

	
	
}

