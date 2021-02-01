package com.business.cybord.models.enums.sql;

public enum SaldoPrestamoFilterEnum {
	MONTO("monto", "monto", false),
	ORIGEN("origen", "origen", true);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private SaldoPrestamoFilterEnum(String paramName, String fieldName, boolean likeable) {
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
