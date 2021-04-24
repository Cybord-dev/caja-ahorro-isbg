package com.business.cybord.models.enums.sql;

public enum SaldoAhorroFilterEnum {

	TIPO("tipo", "tipo", false);

	private String paramName;
	private String fieldName;
	private boolean likeable;

	private SaldoAhorroFilterEnum(String paramName, String fieldName, boolean likeable) {
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
