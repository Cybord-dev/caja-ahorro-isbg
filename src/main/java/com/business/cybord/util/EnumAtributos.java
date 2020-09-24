package com.business.cybord.util;

public enum EnumAtributos {

	NOMBRE("String", "nombre"), EMAIL("String", "email"), TIPOUSUARIO("String", "tipoUsuario"), FECHA("Date", "fechaCreacion"), ESTATUS("Boolean","activo");

	private String tipo;
	private String nameValue;

	private EnumAtributos(String tipo, String nameValue) {
		this.tipo = tipo;
		this.nameValue = nameValue;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

}