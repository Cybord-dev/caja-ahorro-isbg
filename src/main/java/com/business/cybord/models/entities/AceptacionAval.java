package com.business.cybord.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "aceptacion_aval")
public class AceptacionAval implements Serializable{
	
	private static final long serialVersionUID = 4985707770690731426L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_solicitud")
	private int idSolicitud;
	
	@Column(name = "no_empleado_aval")
	private String noEmpleadoAval;
	
	@Column(name = "nombre_deudor")
	private String nombreDeudor;
	
	@Column(name = "no_empleado_deudor")
	private String noEmpleadoDeudor;
	
	@Column(name = "monto_prestamo")
	private BigDecimal montoPrestamo;
	
	@NotNull
	@Column(name = "estatus")
	private String estatus;

	@Column(name = "comentarios")
	private String comentarios;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getNoEmpleadoAval() {
		return noEmpleadoAval;
	}

	public void setNoEmpleadoAval(String noEmpleadoAval) {
		this.noEmpleadoAval = noEmpleadoAval;
	}

	public String getNombreDeudor() {
		return nombreDeudor;
	}

	public void setNombreDeudor(String nombreDeudor) {
		this.nombreDeudor = nombreDeudor;
	}

	public String getNoEmpleadoDeudor() {
		return noEmpleadoDeudor;
	}

	public void setNoEmpleadoDeudor(String noEmpleadoDeudor) {
		this.noEmpleadoDeudor = noEmpleadoDeudor;
	}

	public BigDecimal getMontoPrestamo() {
		return montoPrestamo;
	}

	public void setMontoPrestamo(BigDecimal montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	@Override
	public String toString() {
		return "AceptacionAval [id=" + id + ", idSolicitud=" + idSolicitud + ", noEmpleadoAval=" + noEmpleadoAval
				+ ", nombreDeudor=" + nombreDeudor + ", noEmpleadoDeudor=" + noEmpleadoDeudor + ", montoPrestamo="
				+ montoPrestamo + ", estatus=" + estatus + ", comentarios=" + comentarios + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
}
