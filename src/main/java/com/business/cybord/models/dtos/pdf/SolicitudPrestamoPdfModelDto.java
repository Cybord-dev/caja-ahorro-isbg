package com.business.cybord.models.dtos.pdf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SolicitudPdfModel")
@XmlAccessorType(XmlAccessType.NONE)
public class SolicitudPrestamoPdfModelDto implements Serializable {

	private static final long serialVersionUID = -3226413679610378722L;

	@XmlElement(name = "Fecha")
	private String fecha;
	@XmlElement(name = "Titulo")
	private String titulo;
	@XmlElement(name = "Texto")
	private String texto;
	@XmlElement(name = "Nombre")
	private String nombre;
	@XmlElement(name = "NoEmpleado")
	private String noEmpleado;
	@XmlElement(name = "Cantidad")
	private String cantidad;
	@XmlElement(name = "Oficina")
	private String oficina;
	@XmlElement(name = "Interes")
	private String interes;
	@XmlElement(name = "Total")
	private String total;
	@XmlElement(name = "Quincenas")
	private String quincenas;
	@XmlElement(name = "DescuentoQuincenal")
	private String descuentoQuincenal;
	@XmlElementWrapper(name = "Avales")
	@XmlElement(name = "Aval")
	private List<Aval> avales;

	
	public SolicitudPrestamoPdfModelDto() {
		avales= new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getQuincenas() {
		return quincenas;
	}

	public void setQuincenas(String quincenas) {
		this.quincenas = quincenas;
	}

	public String getDescuentoQuincenal() {
		return descuentoQuincenal;
	}

	public void setDescuentoQuincenal(String descuentoQuincenal) {
		this.descuentoQuincenal = descuentoQuincenal;
	}

	public List<Aval> getAvales() {
		return avales;
	}

	public void setAvales(List<Aval> avales) {
		this.avales = avales;
	}

	@Override
	public String toString() {
		return "SolicitudPRestamoPdfModelDto [fecha=" + fecha + ", titulo=" + titulo + ", texto=" + texto + ", nombre="
				+ nombre + ", noEmpleado=" + noEmpleado + ", cantidad=" + cantidad + ", oficina=" + oficina
				+ ", interes=" + interes + ", total=" + total + ", quincenas=" + quincenas + ", descuentoQuincenal="
				+ descuentoQuincenal + ", avales=" + avales + "]";
	}

}
