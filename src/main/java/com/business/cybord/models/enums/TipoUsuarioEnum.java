package com.business.cybord.models.enums;

public enum TipoUsuarioEnum {
	INTERNO("INTERNO"),
	EXTERNO("EXTERNO");
	
	private String tipo;
	
	private TipoUsuarioEnum(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
}
