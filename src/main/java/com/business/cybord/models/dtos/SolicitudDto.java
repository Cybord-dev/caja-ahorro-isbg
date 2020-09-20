package com.business.cybord.models.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.Validacion;

public class SolicitudDto {
	
	private int id;
	private Integer idUsuario;
	private String tipo;
	private String status;
	private String statusDetalle;
	private BigDecimal porcentaje;
	private BigDecimal cantidad;
	private Date fechaEjecucion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<AtributoSolicitud> atributos;
	private List<Validacion> validaciones;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDetalle() {
		return statusDetalle;
	}
	public void setStatusDetalle(String statusDetalle) {
		this.statusDetalle = statusDetalle;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
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
	
	public List<AtributoSolicitud> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<AtributoSolicitud> atributos) {
		this.atributos = atributos;
	}
	public List<Validacion> getValidaciones() {
		return validaciones;
	}
	public void setValidaciones(List<Validacion> validaciones) {
		this.validaciones = validaciones;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
