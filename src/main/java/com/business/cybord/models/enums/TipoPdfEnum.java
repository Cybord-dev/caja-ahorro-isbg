package com.business.cybord.models.enums;

public enum TipoPdfEnum {

	AHORRO("SolicitudAhorro.xml"), PRESTAMO("SolicitudPrestamo.xml");

	private String file;

	private TipoPdfEnum(String file) {
		this.file=file;
	}

	public String getFile() {
		return file;
	}
}
