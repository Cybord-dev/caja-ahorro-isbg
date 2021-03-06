package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosUsuarioDto implements Serializable {

	private static final long serialVersionUID = -7341927275399580063L;
	private int id;
	private String tipoDato;
	private String dato;
	private boolean relevancia;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date fechaCreacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date fechaActualizacion;

	public DatosUsuarioDto(String tipoDato, String dato, boolean relevancia) {
		super();
		this.tipoDato = tipoDato;
		this.dato = dato;
		this.relevancia = relevancia;
	}

	public DatosUsuarioDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public boolean isRelevancia() {
		return relevancia;
	}

	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
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
		return "DatosUsuarioDto [id=" + id + ", tipoDato=" + tipoDato + ", dato=" + dato + ", relevancia=" + relevancia
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
