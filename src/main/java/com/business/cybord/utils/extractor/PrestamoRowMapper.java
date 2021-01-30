package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.PrestamoDto;

public class PrestamoRowMapper implements RowMapper<PrestamoDto> {

	@Override
	public PrestamoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PrestamoDto result = new PrestamoDto();
		result.setEstatus(rs.getString("estatus"));
		result.setFechaActualizacion(rs.getDate("fecha_actualizacion"));
		result.setFechaCreacion(rs.getDate("fecha_creacion"));
		result.setFechaTerminacion(rs.getDate("fecha_terminacion"));
		result.setId(rs.getInt("id_prestamo"));
		result.setIdDeudor(rs.getInt("id_deudor"));
		result.setMonto(rs.getBigDecimal("monto"));
		result.setNoQuincenas(rs.getInt("no_quincenas"));
		result.setSaldoPendiente(rs.getBigDecimal("saldo_pendiente"));
		result.setTasaInteres(rs.getBigDecimal("tasa_interes"));

		return result;
	}


}
