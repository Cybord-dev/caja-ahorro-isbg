package com.business.cybord.models.dtos;

public class RolCatDto {

	private int id;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RolCatDto [id=" + id + ", nombre=" + nombre + "]";
	}

}
