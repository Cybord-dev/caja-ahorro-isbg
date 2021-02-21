package com.business.cybord.utils.builder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.business.cybord.models.dtos.pdf.Aval;
import com.business.cybord.models.dtos.pdf.SolicitudPrestamoPdfModelDto;

public class SolicitudPrestamoPdfModelDtoBuilder extends AbstractBuilder<SolicitudPrestamoPdfModelDto> {

	private DateFormat dateFormat = new SimpleDateFormat("dd' de 'MMMMM' del 'YYYY");

	public SolicitudPrestamoPdfModelDtoBuilder() {
		super(new SolicitudPrestamoPdfModelDto());
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setFecha(Date fecha) {
		instance.setFecha(dateFormat.format(fecha));
		return this;
	}

	public SolicitudPrestamoPdfModelDtoBuilder setTitulo(String titulo) {
		instance.setTitulo(titulo);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setTexto(String texto) {
		instance.setTexto(texto);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setNombre(String nombre) {
		instance.setNombre(nombre);
		return this;
	}

	public SolicitudPrestamoPdfModelDtoBuilder setCantidad(String cantidad) {
		instance.setCantidad(cantidad);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setDescuentoQuincenal(String descuentoQuincenal) {
		instance.setDescuentoQuincenal(descuentoQuincenal);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setInteres(String interes) {
		instance.setInteres(interes);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setNoEmpleado(String noEmpleado) {
		instance.setNoEmpleado(noEmpleado);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setOficina(String oficina) {
		instance.setOficina(oficina);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setQuincenas(String quincenas) {
		instance.setQuincenas(quincenas);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder setTotal(String total) {
		instance.setTotal(total);
		return this;
	}
	
	public SolicitudPrestamoPdfModelDtoBuilder addAval(String aval) {
		instance.getAvales().add(new Aval(aval));
		return this;
	}

}
