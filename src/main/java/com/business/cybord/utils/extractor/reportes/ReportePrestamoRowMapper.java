package com.business.cybord.utils.extractor.reportes;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.reports.ReportePrestamoDto;

public class ReportePrestamoRowMapper implements RowMapper<ReportePrestamoDto> {

	@Override
	public ReportePrestamoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportePrestamoDto result = new ReportePrestamoDto();
		result.setInteresPrestamo(
				rs.getBigDecimal("interes_prestamo") != null ? rs.getBigDecimal("interes_prestamo") : BigDecimal.ZERO);
		result.setSaldoPendiente(
				rs.getBigDecimal("saldo_pendiente") != null ? rs.getBigDecimal("saldo_pendiente") : BigDecimal.ZERO);
		result.setTipo(rs.getString("estatus"));
		result.setTasaInteres(rs.getBigDecimal("tasa_interes") != null ? rs.getBigDecimal("tasa_interes") : BigDecimal.ZERO);
		result.setInteres(rs.getBigDecimal("interes") != null ? rs.getBigDecimal("interes") : BigDecimal.ZERO);
		result.setPagos(rs.getBigDecimal("pago") != null ? rs.getBigDecimal("pago") : BigDecimal.ZERO);
		result.setAjuste(rs.getBigDecimal("ajuste") != null ? rs.getBigDecimal("ajuste") : BigDecimal.ZERO);
		result.setTotalPagado(
				rs.getBigDecimal("total_pagado") != null ? rs.getBigDecimal("total_pagado") : BigDecimal.ZERO);
		result.setIdUsuario(rs.getInt("id_usuario"));
		result.setTipoUsuario(rs.getString("tipo_usuario"));
		result.setNoEmpleado(rs.getString("no_empleado"));
		result.setNombre(rs.getString("nombre"));
		result.setIdSolicitud(rs.getInt("id_solicitud"));
		result.setNoQuincenas(rs.getInt("no_quincenas"));
		result.setNombre(rs.getString("nombre"));
		result.setMontoPrestamo(
				rs.getBigDecimal("monto") != null ? rs.getBigDecimal("monto") : BigDecimal.ZERO);
		result.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
		result.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion").toLocalDateTime());
		return result;
	}

}