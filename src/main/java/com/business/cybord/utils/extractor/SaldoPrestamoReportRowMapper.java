package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.utils.builder.SaldoPrestamoBuilder;

public class SaldoPrestamoReportRowMapper implements RowMapper<SaldoPrestamoDto> {

	@Override
	public SaldoPrestamoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new SaldoPrestamoBuilder().setId(rs.getInt("id_saldo_prestamo")).setIdPrestamo(rs.getInt("id_prestamo"))
				.setIdUsuario(rs.getInt("id_deudor")).setMontoPrestamo(rs.getBigDecimal("monto_prestamo"))
				.setSaldoPendiente(rs.getBigDecimal("saldo_pendiente")).setEstatus(rs.getString("estatus"))
				.setNoQuincenas(rs.getInt("no_quincenas")).setTasaInteres(rs.getBigDecimal("tasa_interes"))
				.setTipo(rs.getString("tipo")).setOrigen(rs.getString("origen")).setMonto(rs.getBigDecimal("monto"))
				.setValidado(rs.getBoolean("validado")).setNoEmpleado(rs.getString("no_empleado"))
				.setTipoUsuario(rs.getString("tipo_usuario"))
				.setNombreEmpleado(rs.getString("nombre")).setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate())
				.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion").toLocalDateTime()).build();
	}

}
