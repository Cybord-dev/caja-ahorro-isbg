package com.business.cybord.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "validaciones")
public class Validacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_validacion")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "area")
	private String area;

	@Column(name = "id_solicitud")
	private int idSolicitud;

	@NotNull
	@Column(name = "numero_validacion")
	private int numeroValidacion;

	@NotNull
	@Column(name = "estatus")
	private boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_solicitud", insertable = false, updatable = false)
	@JsonIgnore
	private Solicitud solicitud;

	public void update(Validacion n) {
		this.status = n.status;
		this.numeroValidacion = n.numeroValidacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int isNumeroValidacion() {
		return numeroValidacion;
	}

	public void setNumeroValidacion(int numeroValidacion) {
		this.numeroValidacion = numeroValidacion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	@Override
	public String toString() {
		return "Validacion [id=" + id + ", email=" + email + ", area=" + area + ", idSolicitud=" + idSolicitud
				+ ", numeroValidacion=" + numeroValidacion + ", status=" + status + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", solicitud=" + solicitud + "]";
	}

}
