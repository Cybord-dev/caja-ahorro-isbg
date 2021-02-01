/**
 * 
 */
package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hha0009
 *
 */
public class CapacidadPagoDto implements Serializable {

	private static final long serialVersionUID = 30045272020115876L;
	private BigDecimal capacidadPago;
	private BigDecimal sueldo;
	private BigDecimal ahorro;
	private List<ValidacionAvalDto> avalados;
	private List<PrestamoDto> prestamosActivos;

	public BigDecimal getCapacidadPago() {
		return capacidadPago;
	}

	public void setCapacidadPago(BigDecimal capacidadPago) {
		this.capacidadPago = capacidadPago;
	}

	public List<ValidacionAvalDto> getAvalados() {
		return avalados;
	}

	public void setAvalados(List<ValidacionAvalDto> avalados) {
		this.avalados = avalados;
	}

	public List<PrestamoDto> getPrestamosActivos() {
		return prestamosActivos;
	}

	public void setPrestamosActivos(List<PrestamoDto> prestamosActivos) {
		this.prestamosActivos = prestamosActivos;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public BigDecimal getAhorro() {
		return ahorro;
	}

	public void setAhorro(BigDecimal ahorro) {
		this.ahorro = ahorro;
	}

	@Override
	public String toString() {
		return "CapacidadPagoDto [capacidadPago=" + capacidadPago + ", sueldo=" + sueldo + ", ahorro=" + ahorro
				+ ", avalados=" + avalados + ", prestamosActivos=" + prestamosActivos + "]";
	}

}
