package com.business.cybord.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;

	@Column(name = "estatus")
	private Boolean activo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "no_empleado")
	private String noEmpleado;

	@Column(name = "email")
	private String email;

	@Column(name = "tipo_usuario")
	private String tipoUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@OneToMany(mappedBy = "usuario")
	private List<DatosUsuario> datosUsuario;

	@OneToMany(mappedBy = "usuario")
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

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", activo=" + activo + ", nombre=" + nombre + ", noEmpleado=" + noEmpleado
				+ ", email=" + email + ", tipoUsuario=" + tipoUsuario + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", datosUsuario=" + datosUsuario + ", roles=" + roles
				+ "]";
	}

}
