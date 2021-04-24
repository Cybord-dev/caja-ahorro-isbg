package com.business.cybord.models.enums;

public enum TipoAhorroEnum {

	AHORRO("ahorro"),
	DEPOSITO("deposito"),
	INTERES("interes"),
	RETIRO("retiro");
	
	private String tipo;

	private TipoAhorroEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
