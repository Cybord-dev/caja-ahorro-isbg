package com.business.cybord.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "datos_user")
public class DatosUsuario {
	
	@Id	
	@Column(name = "id_datos_user")
	private int id;
	
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "tipo_dato")
	private String tipoDato;
	
	@Column(name = "dato")
	private String dato;
	
	@Column(name = "relevancia")
	private boolean relevancia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name="id_usuario", insertable=false, updatable=false)
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

	public void setIdUsuario(int idUser) {
		this.idUsuario = idUser;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public boolean isRelevancia() {
		return relevancia;
	}

	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
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
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DatosUsuario [id=" + id + ", tipoDato=" + tipoDato + ", dato=" + dato + ", relevancia=" + relevancia
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", usuario="
				+ usuario + "]";
	}

	
		

}
