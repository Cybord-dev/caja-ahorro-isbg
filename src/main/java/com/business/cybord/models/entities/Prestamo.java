package com.business.cybord.models.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PRESTAMO")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo")
	private int id;

	@Column(name = "id_deudor")
	private int idDeudor;

	@Column(name = "estatus")
	private String estatus;

	@Column(name = "monto")
	private BigDecimal monto;
	
	@Column(name = "no_quincenas")
	private int noQuincenas;
	
	@Column(name = "tasa_interes")
	private BigDecimal tasaInteres;
	
	@Column(name = "saldo_pendiente")
	private BigDecimal saldoPendiente;

	@Column(name = "fecha_terminacion")
	private Date fechaTerminacion;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo", insertable = false, updatable = false)
	private List<SaldoPrestamo> saldosPrestamo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDeudor() {
		return idDeudor;
	}

	public void setIdDeudor(int idDeudor) {
		this.idDeudor = idDeudor;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	public int getNoQuincenas() {
		return noQuincenas;
	}

	public void setNoQuincenas(int noQuincenas) {
		this.noQuincenas = noQuincenas;
	}

	public BigDecimal getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	
	public BigDecimal getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(BigDecimal saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public Date getFechaTerminacion() {
		return fechaTerminacion;
	}

	public void setFechaTerminacion(Date fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
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

	public List<SaldoPrestamo> getSaldosPrestamo() {
		return saldosPrestamo;
	}

	public void setSaldosPrestamo(List<SaldoPrestamo> saldosPrestamo) {
		this.saldosPrestamo = saldosPrestamo;
	}

	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", idDeudor=" + idDeudor + ", estatus=" + estatus + ", monto=" + monto
				+ ", noQuincenas=" + noQuincenas + ", tasaInteres=" + tasaInteres + ", fechaTerminacion="
				+ fechaTerminacion + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion
				+ ", saldosPrestamo=" + saldosPrestamo + "]";
	}

}
