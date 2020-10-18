package com.business.cybord.models.enums.sql;

public enum SolicitudFilterEnum {

	TIPO_SOLICITUD("tipoSolicitud", "tipo_solicitud", false),
	ID_SOLICITUD("idSolicitud", "id_solicitud", false),
	ESTATUS("estatus", "estatus", false);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private SolicitudFilterEnum(String paramName, String fieldName, boolean likeable) {
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
