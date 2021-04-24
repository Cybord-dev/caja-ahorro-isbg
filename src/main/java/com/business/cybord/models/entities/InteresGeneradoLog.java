package com.business.cybord.models.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="INTERES_GENERADO_LOG")
public class InteresGeneradoLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_ejecucion")
	private Date fechaEjecucion;
	
	@Column(name = "tipo_usuario")
	private String tipoUsuario;
	
	@Column(name = "saldo_ahorro_total")
	private BigDecimal saldoAhorro;
	
	@Column(name = "interes_generado")
	private BigDecimal interesGenerado;

	@Column(name = "porcentaje_interes")
	private BigDecimal porcentajeInteres;
	
	@Column(name = "interes_repartido")
	private BigDecimal interesRepartido;
	
	@Column(name = "interes_caja")
	private BigDecimal interesCaja;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public BigDecimal getSaldoAhorro() {
		return saldoAhorro;
	}

	public void setSaldoAhorro(BigDecimal saldoAhorro) {
		this.saldoAhorro = saldoAhorro;
	}

	public BigDecimal getInteresGenerado() {
		return interesGenerado;
	}

	public void setInteresGenerado(BigDecimal interesGenerado) {
		this.interesGenerado = interesGenerado;
	}

	public BigDecimal getPorcentajeInteres() {
		return porcentajeInteres;
	}

	public void setPorcentajeInteres(BigDecimal porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
	}

	public BigDecimal getInteresRepartido() {
		return interesRepartido;
	}

	public void setInteresRepartido(BigDecimal interesRepartido) {
		this.interesRepartido = interesRepartido;
	}

	public BigDecimal getInteresCaja() {
		return interesCaja;
	}

	public void setInteresCaja(BigDecimal interesCaja) {
		this.interesCaja = interesCaja;
	}

	@Override
	public String toString() {
		return "InteresGeneradoLog [id=" + id + ", fechaEjecucion=" + fechaEjecucion + ", tipoUsuario=" + tipoUsuario
				+ ", saldoAhorro=" + saldoAhorro + ", interesGenerado=" + interesGenerado + ", porcentajeInteres="
				+ porcentajeInteres + ", interesRepartido=" + interesRepartido + ", interesCaja=" + interesCaja + "]";
	}
	
	
	
	
	

}
