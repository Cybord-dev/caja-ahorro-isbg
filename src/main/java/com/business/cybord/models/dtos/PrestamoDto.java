package com.business.cybord.models.dtos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.business.cybord.entities.SaldoPrestamo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestamoDto {

	private int id;
	private int idDeudor;
	private Boolean estatus;
	private BigDecimal monto;
	private Date fechaTerminacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
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

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
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
				+ ", fechaTerminacion=" + fechaTerminacion + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", saldosPrestamo=" + saldosPrestamo + "]";
	}

}
