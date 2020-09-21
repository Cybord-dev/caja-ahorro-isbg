package com.business.cybord.models.enums;

public enum SolicitudFactoryTypeEnum {

	SOLICITUD_AHORRO(SolicitudFactoryEnum.SOLICITUD_AHORRO, "SolicitudAhorro", "SolicitudCreadaEvent",
			"ValidaContaEvent"),
	SOLICITUD_CANCELACION_AHORRO(SolicitudFactoryEnum.SOLICITUD_CANCELACION_AHORRO, "SolicitudCancelacionAhorro",
			"SolicitudCreadaEvent", "ValidaContaEvent");

	private SolicitudFactoryEnum enumValue;
	private String referenceName;
	private String initState;
	private String finalState;

	private SolicitudFactoryTypeEnum(SolicitudFactoryEnum enumValue,String referenceName, String initState, String finalState) {
		this.enumValue = enumValue;
		this.referenceName=referenceName;
		this.initState = initState;
		this.finalState = finalState;
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
	
	public static SolicitudFactoryTypeEnum findByReferenceName(String referenceName) {
		for (SolicitudFactoryTypeEnum v : values()) {
			if (v.getReferenceName().equals(referenceName)) {
				return v;
			}
		}
		return null;
	}

}
