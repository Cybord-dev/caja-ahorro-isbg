/**
 * 
 */
package com.business.cybord.models.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Solicitudes")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private int id;

	@NotNull
	@Column(name = "tipo_solicitud")
	private String tipo;

	@NotNull
	@Column(name = "estatus")
	private String status;

	@NotNull
	@Column(name = "estatus_detalle")
	private String statusDetalle;

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
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "solicitud")
	private List<AtributoSolicitud> atributos;

	@OneToMany(mappedBy = "solicitud")
	private List<ValidacionSolicitud> validaciones;

	public void update(Solicitud n) {
		this.fechaEjecucion = n.getFechaEjecucion();
		this.status = n.getStatus();
		this.statusDetalle = n.getStatusDetalle();
	}
	
	public Map<String, String> getAttributesAsMap(){
		return atributos.stream().collect(Collectors.toMap(AtributoSolicitud::getNombre, AtributoSolicitud::getValor));
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDetalle() {
		return statusDetalle;
	}

	public void setStatusDetalle(String statusDetalle) {
		this.statusDetalle = statusDetalle;
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

	public List<ValidacionSolicitud> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(List<ValidacionSolicitud> validaciones) {
		this.validaciones = validaciones;
	}


	@Override
	public String toString() {
		return "Solicitud [id=" + id  + ", tipo=" + tipo + ", status=" + status
				+ ", statusDetalle=" + statusDetalle + ", fechaEjecucion=" + fechaEjecucion + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", usuario=" + usuario + ", atributos="
				+ atributos + ", validaciones=" + validaciones + "]";
	}

}
