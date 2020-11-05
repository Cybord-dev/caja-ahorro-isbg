package com.business.cybord.utils.builder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.business.cybord.models.dtos.pdf.SolicitudPdfModelDto;

public class SolicitudPdfModelDtoBuilder extends AbstractBuilder<SolicitudPdfModelDto> {

	private DateFormat dateFormat = new SimpleDateFormat("dd' de 'MMMMM' del 'YYYY");

	public SolicitudPdfModelDtoBuilder() {
		super(new SolicitudPdfModelDto());
	}

	public SolicitudPdfModelDtoBuilder setFecha(Date fecha) {
		instance.setFecha(dateFormat.format(fecha));
		return this;
	}

	public SolicitudPdfModelDtoBuilder setTitulo(String titulo) {
		instance.setTitulo(titulo);
		return this;
	}
	
	public SolicitudPdfModelDtoBuilder setTexto(String texto) {
		instance.setTexto(texto);
		return this;
	}
	
	public SolicitudPdfModelDtoBuilder setNombre(String nombre) {
		instance.setNombre(nombre);
		return this;
	}

}
