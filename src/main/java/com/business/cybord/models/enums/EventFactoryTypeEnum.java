package com.business.cybord.models.enums;

import java.util.Optional;

public enum EventFactoryTypeEnum {

	SOLICITUD_CREADA(EventFactoryEnum.SOLICITUD_CREADA, "sistema","Solicitud"),
	VALIDA_RH(EventFactoryEnum.VALIDA_RH_EVENT, "recursos-humanos","ValidacionRH"),
	VALIDA_CONTA_EVENT(EventFactoryEnum.VALIDA_CONTA_EVENT, "contabilidad","ValdiacionConta"),
	VALIDA_ADMIN(EventFactoryEnum.VALIDA_ADMIN_EVENT, "administracion","ValidaAdmin"),
	VALIDA_GERENCIA_EXTERNA(EventFactoryEnum.VALIDA_GERENCIA_EXTERNA_EVENT, "gerencia-externa","ValidacionGerenciaExterna"),
	VALIDA_GERENCIA_INTERNA(EventFactoryEnum.VALIDA_GERENCIA_INTERNA_EVENT, "gerencia-interna","ValidacionGerenciaInterna"),
	VALIDA_DIRECCION(EventFactoryEnum.VALIDA_DIRECCION_EVENT, "direccion","ValidacionDireccion"),
	VALIDA_TESO(EventFactoryEnum.VALIDA_TESO_EVENT, "tesoreria","ValidacionTeso"),
	SOLICITUD_TERMINADA(EventFactoryEnum.SOLICITUD_TERMINADA, "sistema","Finalizada");
	

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


	public static Optional<EventFactoryTypeEnum> findByReferenceName(String referenceName) {
		for (EventFactoryTypeEnum v : values()) {
			if (v.getReferenceName().equals(referenceName)) {
				return Optional.of(v);
			}
		}
		return Optional.empty();
	}
}
