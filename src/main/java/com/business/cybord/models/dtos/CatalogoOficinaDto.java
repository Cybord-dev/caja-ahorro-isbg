package com.business.cybord.models.dtos;

public class CatalogoOficinaDto {

	private int id;
	private String oficina;
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "CatalogoOficinaDto [id=" + id + ", oficina=" + oficina + ", tipo=" + tipo + "]";
	}

}
