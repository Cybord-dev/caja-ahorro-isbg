package com.business.cybord.models.enums.sql;

public enum PrestamoFilterEnum {

	ID_DEUDOR("id_deudor", "id_deudor", false),
	ID_PRESTAMO("id_prestamo", "id_prestamo", false),
	ID_SOLICITUD("id_solicitud", "id_solicitud", false),
	NO_QUINCENAS("no_quincenas", "no_quincenas", false),
	ESTATUS("estatus", "estatus", false);

	
	private String paramName;
	private String fieldName;
	private boolean likeable;

	private PrestamoFilterEnum(String paramName, String fieldName, boolean likeable) {
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
