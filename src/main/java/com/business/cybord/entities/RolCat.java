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
@Table(name = "CAT_ROLES")
public class RolCat {
	
	@Id	
	@Column(name = "id_role")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Rol rol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "RolCat [id=" + id + ", nombre=" + nombre + ", rol=" + rol + "]";
	}
	
	
}
