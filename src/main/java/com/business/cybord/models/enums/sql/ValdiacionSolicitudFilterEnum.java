package com.business.cybord.models.enums.sql;

public enum ValdiacionSolicitudFilterEnum {

	CORREO("email", "email", true),
	AREA("area", "area", false),
	ESTATUS("status", "estatus", false);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private ValdiacionSolicitudFilterEnum(String paramName, String fieldName, boolean likeable) {
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
