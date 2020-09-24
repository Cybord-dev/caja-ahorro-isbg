package com.business.cybord.models.enums;

public enum EventFactoryTypeEnum {

	SOLIICITUD_CREADA(null, "System","SolicitudCreadaEvent"),
	VALIDA_RH(EventFactoryEnum.VALIDA_RH_EVENT, "RecursosHumanos","ValidaRhEvent"),
	VALIDA_CONTA_EVENT(EventFactoryEnum.VALIDA_CONTA_EVENT, "Contabilidad","ValidaContaEvent");
	

	private EventFactoryEnum enumValue;
	private String referenceName;
	private String state;

	private EventFactoryTypeEnum(EventFactoryEnum enumValue,String referenceName,String state) {
		this.enumValue = enumValue;
		this.referenceName=referenceName;
		this.state=state;
	}

	public EventFactoryEnum getEnumValue() {
		return enumValue;
	}

	public String getReferenceName() {
		return referenceName;
	}
	
	

	public String getState() {
		return state;
	}


	public static EventFactoryTypeEnum findByReferenceName(String referenceName) {
		for (EventFactoryTypeEnum v : values()) {
			if (v.getReferenceName().equals(referenceName)) {
				return v;
			}
		}
		return null;
	}
}
