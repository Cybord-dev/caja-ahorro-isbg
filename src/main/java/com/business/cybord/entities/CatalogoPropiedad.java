package com.business.cybord.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cat_propiedades")
public class CatalogoPropiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atributo")
	private int id;

	@NonNull
	@Column(name = "tipo")
	private String tipo;

	@NonNull
	@Column(name = "nombre")
	private String nombre;

	@NonNull
	@Column(name = "valor")
	private String valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "CatalogoPropiedad [id=" + id + ", tipo=" + tipo + ", nombre= " + nombre + ", valor=" + valor + "]";
	}

}
