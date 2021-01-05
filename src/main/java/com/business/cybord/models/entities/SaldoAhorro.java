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
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SALDO_AHORRO")
public class SaldoAhorro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ahorro")
	private int id;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "monto")
	private BigDecimal monto;

	@Column(name = "validado")
	private Boolean validado;

	@Column(name = "origen")
	private String origen;
	
	@Column(name = "observaciones")
	private String observaciones;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	public SaldoAhorro() {
		super();
	}

	public SaldoAhorro(int idUsuario, String tipo, BigDecimal monto, Boolean validado) {
		super();
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.monto = monto;
		this.validado = validado;
	}

	public SaldoAhorro(int id,int idUsuario, String tipo, BigDecimal monto, Boolean validado,String origen) {
		super();
		this.id=id;
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.monto = monto;
		this.validado = validado;
		this.origen=origen;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "SaldoAhorro [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", monto=" + monto
				+ ", validado=" + validado + ", origen=" + origen + ", observaciones=" + observaciones
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
}
