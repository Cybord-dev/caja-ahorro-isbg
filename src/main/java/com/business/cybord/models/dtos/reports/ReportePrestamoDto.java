package com.business.cybord.models.dtos.reports;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportePrestamoDto implements Serializable {

	private static final long serialVersionUID = 2464640685213535486L;

	private Integer idUsuario;
	private String tipoUsuario;
	private String noEmpleado;
	private String nombre;

	private Integer idSolicitud;
	private String estatus;
	private Integer noQuincenas;

	private BigDecimal montoPrestamo;
	private BigDecimal interesPrestamo;
	private BigDecimal saldoPendiente;
	private BigDecimal interes;
	private BigDecimal pagos;
	private BigDecimal ajuste;
	private BigDecimal totalPagado;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
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

	public BigDecimal getMontoPrestamo() {
		return montoPrestamo;
	}

	public void setMontoPrestamo(BigDecimal montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getPagos() {
		return pagos;
	}

	public void setPagos(BigDecimal pagos) {
		this.pagos = pagos;
	}

	public BigDecimal getAjuste() {
		return ajuste;
	}

	public void setAjuste(BigDecimal ajuste) {
		this.ajuste = ajuste;
	}

	public BigDecimal getInteresPrestamo() {
		return interesPrestamo;
	}

	public void setInteresPrestamo(BigDecimal interesPrestamo) {
		this.interesPrestamo = interesPrestamo;
	}

	public BigDecimal getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(BigDecimal saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public BigDecimal getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(BigDecimal totalPagado) {
		this.totalPagado = totalPagado;
	}

	@Override
	public String toString() {
		return "ReportePrestamoDto [idUsuario=" + idUsuario + ", tipoUsuario=" + tipoUsuario + ", noEmpleado="
				+ noEmpleado + ", nombre=" + nombre + ", idSolicitud=" + idSolicitud + ", estatus=" + estatus
				+ ", noQuincenas=" + noQuincenas + ", montoPrestamo=" + montoPrestamo + ", interesPrestamo="
				+ interesPrestamo + ", saldoPendiente=" + saldoPendiente + ", interes=" + interes + ", pagos=" + pagos
				+ ", ajuste=" + ajuste + ", totalPagado=" + totalPagado + "]";
	}

}
