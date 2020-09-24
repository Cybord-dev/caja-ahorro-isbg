package com.business.cybord.models.entities;

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

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER_ROLES")
public class Rol {

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rol", referencedColumnName = "id_role", insertable = false, updatable = false)
	private RolCat rolname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Rol [id=" + id + ", usuario=" + usuario + ", rolname=" + rolname + "]";
	}

}
