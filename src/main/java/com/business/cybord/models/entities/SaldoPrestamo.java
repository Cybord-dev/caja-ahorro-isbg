package com.business.cybord.models.entities;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SALDO_PRESTAMO")
public class SaldoPrestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_saldo_prestamo")
	private int id;

	@Column(name = "id_prestamo")
	private int idPrestamo;
	
	@Column(name = "no_pago")
	private int noPago;
	

	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "origen")
	private String origen;

	@Column(name = "monto")
	private BigDecimal monto;

	@Column(name = "validado")
	private String validado;
	
	@Column(name = "observaciones")
	private String observaciones;

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

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getValidado() {
		return validado;
	}

	public void setValidado(String validado) {
		this.validado = validado;
	}
	
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public int getNoPago() {
		return noPago;
	}

	public void setNoPago(int noPago) {
		this.noPago = noPago;
	}

	@Override
	public String toString() {
		return "SaldoPrestamo [id=" + id + ", idPrestamo=" + idPrestamo + ", noPago=" + noPago + ", tipo=" + tipo
				+ ", origen=" + origen + ", monto=" + monto + ", validado=" + validado + ", observaciones="
				+ observaciones + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion
				+ "]";
	}

	

}
