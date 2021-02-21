package com.business.cybord.models.enums.sql;

public enum ValidacionAvalFilterEnum {
	
	ID_USUARIO_AVAL("id_usuario_aval", "id_usuario_aval", false),
	ID_USUARIO_DEUDOR("id_usuario_deudor", "id_usuario_deudor", false),
	NOMBRE_DEUDOR("nombre_deudor", "nombre_deudor", true),
	NOMBRE_AVAL("nombre_aval", "nombre_aval", true),
	ESTATUS("estatus", "estatus", false);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private ValidacionAvalFilterEnum(String paramName, String fieldName, boolean likeable) {
		this.paramName = paramName;
		this.fieldName = fieldName;
		this.likeable = likeable;
	}

	public String getParamName() {
		return paramName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public boolean isLikeable() {
		return likeable;
	}

}
