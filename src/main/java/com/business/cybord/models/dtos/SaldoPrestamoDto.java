package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaldoPrestamoDto implements Serializable {

	private static final long serialVersionUID = -2216085691198955917L;
	private Integer id;
	private Integer idPrestamo;
	// =============================
	private Integer idUsuario;
	private Integer noPago;
	private BigDecimal montoPrestamo;
	private BigDecimal saldoPendiente;
	private String estatus;
	private Integer noQuincenas;
	private BigDecimal tasaInteres;
	// =============================
	private String noEmpleado;
	private String nombreEmpleado;
	private String tipoUsuario;
	// =============================
	private String tipo;
	private String origen;
	private BigDecimal monto;
	private String validado;
	private String observaciones;
	private LocalDate fechaCreacion;
	private LocalDateTime fechaActualizacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPrestamo() {
		return idPrestamo;
	}
	
	

	public Integer getNoPago() {
		return noPago;
	}

	public void setNoPago(Integer noPago) {
		this.noPago = noPago;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getMontoPrestamo() {
		return montoPrestamo;
	}

	public void setMontoPrestamo(BigDecimal montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}

	public BigDecimal getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(BigDecimal saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getNoQuincenas() {
		return noQuincenas;
	}

	public void setNoQuincenas(Integer noQuincenas) {
		this.noQuincenas = noQuincenas;
	}

	public BigDecimal getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "SaldoPrestamoDto [id=" + id + ", idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", noPago="
				+ noPago + ", montoPrestamo=" + montoPrestamo + ", saldoPendiente=" + saldoPendiente + ", estatus="
				+ estatus + ", noQuincenas=" + noQuincenas + ", tasaInteres=" + tasaInteres + ", noEmpleado="
				+ noEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", tipoUsuario=" + tipoUsuario + ", tipo=" + tipo
				+ ", origen=" + origen + ", monto=" + monto + ", validado=" + validado + ", observaciones="
				+ observaciones + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion
				+ "]";
	}

	


	
}
