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
	private List<UsuarioDto> avalados;
	private List<PrestamoDto> prestamosActivos;
	public BigDecimal getCapacidadPago() {
		return capacidadPago;
	}
	public void setCapacidadPago(BigDecimal capacidadPago) {
		this.capacidadPago = capacidadPago;
	}
	public List<UsuarioDto> getAvalados() {
		return avalados;
	}
	public void setAvalados(List<UsuarioDto> avalados) {
		this.avalados = avalados;
	}
	public List<PrestamoDto> getPrestamosActivos() {
		return prestamosActivos;
	}
	public void setPrestamosActivos(List<PrestamoDto> prestamosActivos) {
		this.prestamosActivos = prestamosActivos;
	}
	
	@Override
	public String toString() {
		return "CapacidadPagoDto [capacidadPago=" + capacidadPago + ", avalados=" + avalados + ", prestamosActivos="
				+ prestamosActivos + "]";
	}

}
