package com.business.cybord.models;

public enum Meses {
	
	ENERO("1"),
	FEBRERO("2"),
	MARZO("3"),
	ABRIL("4"),
	MAYO("5"),
	JUNIO("6"),
	JULIO("7"),
	AGOSTO("8"),
	SEPTIEMBRE("9"),
	OCTUBRE("10"),
	NOVIEMBRE("11"),
	DICIEMBRE("12"),
	INVALIDO("MES");
	
	private String number;

	Meses(String number) {
		this.number = number;
	}
	
	
	
	public String getNumber() {
		return number;
	}

	public static Meses getMesByNumber(String number){
		for (Meses mes : Meses.values()) {
			if(mes.getNumber().equals(number)) {
				return mes;
			}
		}
		return Meses.INVALIDO;
	}

}
