package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.composed.ReporteSaldosDto;

public class ReporteSaldosRowMapper implements RowMapper<ReporteSaldosDto> {

	@Override
	public ReporteSaldosDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReporteSaldosDto result = new ReporteSaldosDto();
		result.setTipo(rs.getString("tipo"));
		result.setMonto(rs.getBigDecimal("monto"));
		result.setFecha(rs.getString("fecha_creacion"));
		result.setOrigen(rs.getString("origen"));
		result.setAhorrador(rs.getString("nombre"));
		result.setNoEmpleado(rs.getString("no_empleado"));
		result.setTipoEmpleado(rs.getString("tipo_usuario"));
		return result;
	}

}
