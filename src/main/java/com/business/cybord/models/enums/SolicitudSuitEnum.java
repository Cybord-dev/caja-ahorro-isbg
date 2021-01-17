package com.business.cybord.models.enums;

import java.util.Optional;

public enum SolicitudSuitEnum {

	SOLICITUD_AHORRO_SUITE("SolicitudAhorro"),
	CANCELACION_AHORRO_SUITE("CancelacionAhorro"),
	MODIFICACION_AHORRO_SUITE("ModificacionAhorro"),
	RETIRO_PARCIAL_AHORRO_SUITE("RetiroParcialAhorro"),
	
	SOLICITUD_PRESTAMO_SUITE("SolicitudPrestamo");

	private String suite;

	private SolicitudSuitEnum(String suite) {
		this.suite = suite;
	}

	public String getSuite() {
		return suite;
	}

	public static Optional<SolicitudSuitEnum> findBySuite(String suite) {
		for (SolicitudSuitEnum v : values()) {
			if (v.getSuite().equals(suite)) {
				return Optional.of(v);
			}
		}
		return Optional.empty();
	}

}