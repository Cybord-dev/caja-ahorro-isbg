package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestamoDto implements Serializable {

	private static final long serialVersionUID = -4411000742264499694L;
	private int id;
	private int idDeudor;
	private String estatus;
	private BigDecimal monto;
	private int noQuincenas;
	private BigDecimal tasaInteres;
	private BigDecimal saldoPendiente;
	private Date fechaTerminacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<SaldoPrestamoDto> saldosPrestamo;
	private SolicitudDto solicitud;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<SaldoPrestamoDto> getSaldosPrestamo() {
		return saldosPrestamo;
	}

	public void setSaldosPrestamo(List<SaldoPrestamoDto> saldosPrestamo) {
		this.saldosPrestamo = saldosPrestamo;
	}

	public SolicitudDto getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudDto solicitud) {
		this.solicitud = solicitud;
	}

	@Override
	public String toString() {
		return "PrestamoDto [id=" + id + ", idDeudor=" + " idSolicitud  " + ", estatus=" + estatus + ", monto=" + monto
				+ ", noQuincenas=" + noQuincenas + ", tasaInteres=" + tasaInteres + ", saldoPendiente=" + saldoPendiente
				+ ", fechaTerminacion=" + fechaTerminacion + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", saldosPrestamo=" + saldosPrestamo + "]";
	}

	public int getIdDeudor() {
		return idDeudor;
	}

	public void setIdDeudor(int idDeudor) {
		this.idDeudor = idDeudor;
	}
}
