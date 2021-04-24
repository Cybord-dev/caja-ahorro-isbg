package com.business.cybord.models.dtos.pdf;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SolicitudPdfModel")
@XmlAccessorType(XmlAccessType.NONE)
public class Aval implements Serializable {

	private static final long serialVersionUID = 1745929178149550823L;
	
	@XmlAttribute(name = "Nombre")
	private String Nombre;

	public Aval() {
		super();
	}

	public Aval(String nombre) {
		super();
		Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Aval [Nombre=" + Nombre + "]";
	}

}
