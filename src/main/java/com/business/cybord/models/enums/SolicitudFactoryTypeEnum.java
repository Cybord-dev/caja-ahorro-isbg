package com.business.cybord.models.enums;

import java.util.Optional;

public enum SolicitudFactoryTypeEnum {

	SOLICITUD_AHORRO_INTERNO(SolicitudFactoryEnum.SOLICITUD_AHORRO_INTERNO, "SolicitudAhorro", "SolicitudCreadaEvent",
			"ValidaContaEvent","INTERNO"),
	SOLICITUD_AHORRO_EXTERNO(SolicitudFactoryEnum.SOLICITUD_AHORRO_EXTERNO, "SolicitudAhorro", "SolicitudCreadaEvent",
			"ValidaContaEvent","EXTERNO"),
	SOLICITUD_CANCELACION_AHORRO_INTERNO(SolicitudFactoryEnum.SOLICITUD_CANCELACION_AHORRO_INTERNO, "CancelacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","INTERNO"),
	SOLICITUD_CANCELACION_AHORRO_EXTERNO(SolicitudFactoryEnum.SOLICITUD_CANCELACION_AHORRO_EXTERNO, "CancelacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","EXTERNO"),
	SOLICITUD_RETIRO_PARCIAL_AHORRO_INTERNO(SolicitudFactoryEnum.SOLICITUD_RETIRO_PARCIAL_AHORRO_INTERNO, "RetiroParcialAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","INTERNO"),
	SOLICITUD_RETIRO_PARCIAL_AHORRO_EXTERNO(SolicitudFactoryEnum.SOLICITUD_RETIRO_PARCIAL_AHORRO_EXTERNO, "RetiroParcialAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","EXTERNO"),
	SOLICITUD_MODIFICACION_AHORRO_INTERNO(SolicitudFactoryEnum.SOLICITUD_MODIFICACION_AHORRO_INTERNO, "ModificacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","INTERNO"),
	SOLICITUD_MODIFICACION_AHORRO_EXTENO(SolicitudFactoryEnum.SOLICITUD_MODIFICACION_AHORRO_EXTERNO, "ModificacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","EXTERNO"),
	SOLICITUD_PRESTAMO_INTERNO(SolicitudFactoryEnum.SOLICITUD_PRESTAMO_INTERNO, "ModificacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","INTERNO"),
	SOLICITUD_PRESTAMO_EXTERNO(SolicitudFactoryEnum.SOLICITUD_PRESTAMO_EXTERNO, "ModificacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent","EXTERNO");

	private SolicitudFactoryEnum enumValue;
	private String referenceName;
	private String tipo;
	private String initState;
	private String finalState;

	private SolicitudFactoryTypeEnum(SolicitudFactoryEnum enumValue, String referenceName, String initState,
			String finalState, String tipo) {
		this.enumValue = enumValue;
		this.referenceName = referenceName;
		this.initState = initState;
		this.finalState = finalState;
		this.tipo = tipo;
	}

	public SolicitudFactoryEnum getEnumValue() {
		return enumValue;
	}

	public String getInitState() {
		return initState;
	}

	public String getFinalState() {
		return finalState;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public String getTipo() {
		return tipo;
	}

	public static Optional<SolicitudFactoryTypeEnum> findByReferenceName(String referenceName, String tipo) {
		for (SolicitudFactoryTypeEnum v : values()) {
			if (v.getReferenceName().equals(referenceName)&&v.getTipo().equals(tipo)) {
				return Optional.of(v);
			}
		}
		return Optional.empty();
	}
}
