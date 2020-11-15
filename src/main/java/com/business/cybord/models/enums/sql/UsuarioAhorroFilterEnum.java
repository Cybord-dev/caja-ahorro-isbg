package com.business.cybord.models.enums.sql;

public enum UsuarioAhorroFilterEnum {

	NOMBRE("nombre", "nombre", true),
	NO_EMPLEADO("noEmpleado", "no_empleado", false),
	EMAIL("email", "email", true),
	ESTATUS("estatus", "estatus", false),
	TIPO_USUARIO("tipoUsuario", "tipo_usuario", false);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private UsuarioAhorroFilterEnum(String paramName, String fieldName, boolean likeable) {
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
