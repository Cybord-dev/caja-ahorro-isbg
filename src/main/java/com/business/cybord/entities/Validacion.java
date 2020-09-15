package com.business.cybord.entities;

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
	
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "id_solicitud")
	private int idSolicitud;
	
	@NotNull
	@Column(name = "numero_validacion")
	private boolean numeroValidacion;
	
	@NotNull
	@Column(name = "estatus")
	private boolean status;
	
	@NotNull
	@Column(name = "tipo_validacion")
	private String tipoValidacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name="id_usuario", insertable=false, updatable=false)
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name="id_solicitud", insertable=false, updatable=false)
	private Solicitud solicitud;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNumeroValidacion() {
		return numeroValidacion;
	}

	public void setNumeroValidacion(boolean numeroValidacion) {
		this.numeroValidacion = numeroValidacion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTipoValidacion() {
		return tipoValidacion;
	}

	public void setTipoValidacion(String tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
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

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@Override
	public String toString() {
		return "Validacion [id=" + id + ", idUsuario=" + idUsuario + ", idSolicitud=" + idSolicitud
				+ ", numeroValidacion=" + numeroValidacion + ", status=" + status + ", tipoValidacion=" + tipoValidacion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", usuario="
				+ usuario + ", solicitud=" + solicitud + ", getId()=" + getId() + ", isNumeroValidacion()="
				+ isNumeroValidacion() + ", isStatus()=" + isStatus() + ", getTipoValidacion()=" + getTipoValidacion()
				+ ", getFechaCreacion()=" + getFechaCreacion() + ", getFechaActualizacion()=" + getFechaActualizacion()
				+ ", getUsuario()=" + getUsuario() + ", getSolicitud()=" + getSolicitud() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
