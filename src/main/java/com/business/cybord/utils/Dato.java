package com.business.cybord.utils;

public class Dato<T>{
	T objeto;
	public Dato(T objeto) {
		this.objeto = objeto;
	}
	
	@Override
	public String toString() {
		return (String) objeto;
	}
	
}
