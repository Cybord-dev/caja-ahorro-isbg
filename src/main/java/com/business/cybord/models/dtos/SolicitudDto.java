package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolicitudDto implements Serializable{

	private static final long serialVersionUID = 1437291290675415033L;
	private int id;
	private Integer idUsuario;
	private String tipo;
	private String status;
	private String statusDetalle;
	private Date fechaEjecucion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<AtributoSolicitudDto> atributos;
	private List<ValidacionDto> validaciones;

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

	public List<AtributoSolicitudDto> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<AtributoSolicitudDto> atributos) {
		this.atributos = atributos;
	}

	public List<ValidacionDto> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(List<ValidacionDto> validaciones) {
		this.validaciones = validaciones;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "SolicitudDto [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", status=" + status
				+ ", statusDetalle=" + statusDetalle + ", fechaEjecucion=" + fechaEjecucion + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", atributos=" + atributos
				+ ", validaciones=" + validaciones + "]";
	}

}
