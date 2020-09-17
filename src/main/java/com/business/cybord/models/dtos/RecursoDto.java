package com.business.cybord.models.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecursoDto {
	
	private int id;
	private String referencia;
	private Boolean tipoReferencia;
	private String documento;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Boolean getTipoReferencia() {
		return tipoReferencia;
	}
	public void setTipoReferencia(Boolean tipoReferenciaBoolean) {
		this.tipoReferencia = tipoReferenciaBoolean;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
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
		return "RecursoDto [id=" + id + ", referencia=" + referencia + ", tipoReferenciaBoolean="
				+ tipoReferencia + ", documento=" + documento + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	
	

}
