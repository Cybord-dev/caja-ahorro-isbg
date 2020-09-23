/**
 * 
 */
package com.business.cybord.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Solicitudes")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private int id;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@NotNull
	@Column(name = "tipo_solicitud")
	private int tipo;

	@NotNull
	@Column(name = "estatus")
	private int estatus;

	@NotNull
	@Column(name = "estatus_detalle")
	private String estatusDetalle;

	@NotNull
	@Column(name = "porcentaje")
	private BigDecimal porcentaje;

	@NotNull
	@Column(name = "cantidad")
	private BigDecimal cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ejecucion")
	private Date fechaEjecucion;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	@JsonIgnore
	private Usuario usuario;

	@OneToMany(mappedBy = "solicitud")
	@JsonIgnore
	private List<AtributoSolicitud> atributos;

	@OneToMany(mappedBy = "solicitud")
	@JsonIgnore
	private List<Validacion> validaciones;

	public void update(Solicitud n) {
		this.fechaEjecucion = n.getFechaEjecucion();
		this.cantidad = n.getCantidad();
		this.porcentaje = n.getPorcentaje();
		this.estatus = n.getStatus();
		this.estatusDetalle = n.getStatusDetalle();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return estatus;
	}

	public void setStatus(int status) {
		this.estatus = status;
	}

	public String getStatusDetalle() {
		return estatusDetalle;
	}

	public void setStatusDetalle(String statusDetalle) {
		this.estatusDetalle = statusDetalle;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AtributoSolicitud> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<AtributoSolicitud> atributos) {
		this.atributos = atributos;
	}

	public List<Validacion> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(List<Validacion> validaciones) {
		this.validaciones = validaciones;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", status=" + estatus
				+ ", statusDetalle=" + estatusDetalle + ", porcentaje=" + porcentaje + ", cantidad=" + cantidad
				+ ", fechaEjecucion=" + fechaEjecucion + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", usuario=" + usuario + ", atributos=" + atributos + ", validaciones="
				+ validaciones + "]";
	}

}
