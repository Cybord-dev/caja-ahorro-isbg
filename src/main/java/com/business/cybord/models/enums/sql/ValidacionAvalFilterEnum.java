package com.business.cybord.models.enums.sql;

public enum ValidacionAvalFilterEnum {
	
	NO_EMPLEADO_AVAL("no_empleado_aval", "no_empleado_aval", false),
	NO_EMPLEADO_DEUDOR("no_empleado_deudor", "no_empleado_deudor", false),
	NOMBRE_DEUDOR("no_empleado_deudor", "no_empleado_deudor", true),
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
