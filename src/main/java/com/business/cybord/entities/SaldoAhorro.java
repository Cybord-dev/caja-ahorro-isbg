package com.business.cybord.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
>>>>>>> feature/paginados
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

<<<<<<< HEAD
@Entity
@EntityListeners(AuditingEntityListener.class)
<<<<<<< HEAD:src/main/java/com/business/cybord/entities/SaldoAhorro.java
=======
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
>>>>>>> feature/paginados
@Table(name = "SALDO_AHORRO")
public class SaldoAhorro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ahorro")
	private int id;

	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "monto")
	private BigDecimal monto;

<<<<<<< HEAD
=======
@Table(name = "SALDO_PRESTAMO")
public class SaldoPrestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_saldo_prestamo")
	private int id;

	@Column(name = "id_prestamo")
	private int idPrestamo;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "monto")
	private BigDecimal monto;

>>>>>>> feature/paginados:src/main/java/com/business/cybord/entities/SaldoPrestamo.java
=======
>>>>>>> feature/paginados
	@Column(name = "validado")
	private Boolean validado;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

<<<<<<< HEAD
=======
	@ManyToOne(optional = false)
	@JsonIgnore
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;
	
>>>>>>> feature/paginados
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/com/business/cybord/entities/SaldoAhorro.java
=======
>>>>>>> feature/paginados
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
<<<<<<< HEAD
=======
	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
>>>>>>> feature/paginados:src/main/java/com/business/cybord/entities/SaldoPrestamo.java
=======
>>>>>>> feature/paginados
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

<<<<<<< HEAD
	@Override
	public String toString() {
<<<<<<< HEAD:src/main/java/com/business/cybord/entities/SaldoAhorro.java
		return "SaldoAhorro [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", monto=" + monto
=======
		return "SaldoPrestamo [id=" + id + ", idPrestamo=" + idPrestamo + ", tipo=" + tipo + ", monto=" + monto
>>>>>>> feature/paginados:src/main/java/com/business/cybord/entities/SaldoPrestamo.java
=======
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "SaldoAhorro [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", monto=" + monto
>>>>>>> feature/paginados
				+ ", validado=" + validado + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + "]";
	}

}
