package com.business.cybord.models.enums.sql;

public enum PrestamoFilterEnum {

	ID_DEUDOR("idDeudor", "id_deudor", false),
	ID_PRESTAMO("idPrestamo", "id_prestamo", false),
	ID_SOLICITUD("idSolicitud", "id_solicitud", false),
	NO_QUINCENAS("noQuincenas", "no_quincenas", false),
	ESTATUS("tipo", "estatus", false);

	
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
