package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecursoDto  implements Serializable {
	


	private static final long serialVersionUID = 7706483751972616212L;
	private int id;
	private String referencia;
	private String tipoArchivo;
	private String tipoRecurso;
	private String dato;
	private Date fechaCreacion;
	
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
	public String getTipoArchivo() {
		return tipoArchivo;
	}
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}
	public String getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(String tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String documento) {
		this.dato = documento;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "RecursoDto [id=" + id + ", referencia=" + referencia + ", tipoArchivo=" + tipoArchivo + ", tipoRecurso="
				+ tipoRecurso + ", dato=" + dato + ", fechaCreacion=" + fechaCreacion
				+ "]";
	}
	
	
	
}
