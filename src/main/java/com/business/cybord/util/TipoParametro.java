package com.business.cybord.util;

public class TipoParametro {

	private String value;
	private String seconValue;
	private EnumAtributos atributo;

	public TipoParametro(EnumAtributos atributo, String value) {
		this.atributo = atributo;
		this.value = value;
	}
	public TipoParametro(EnumAtributos atributo, String value , String seconValue) {
		this.atributo = atributo;
		this.value = value;
		this.seconValue = seconValue;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSeconValue() {
		return seconValue;
	}

	public void setSeconValue(String seconValue) {
		this.seconValue = seconValue;
	}

	public EnumAtributos getAtributo() {
		return atributo;
	}

	public void setAtributo(EnumAtributos atributo) {
		this.atributo = atributo;
	}

	public String getValue() {
		return value;
	}

}
