package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.SaldoAhorroDto;

public class SaldoAhorroDtoRowMapper implements RowMapper<SaldoAhorroDto> {

	@Override
	public SaldoAhorroDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaldoAhorroDto result = new SaldoAhorroDto();
		
		result.setId(rs.getInt("id_ahorro"));
		result.setIdUsuario(rs.getInt("id_usuario"));
		result.setMonto(rs.getBigDecimal("monto"));
		result.setValidado(rs.getBoolean("validado"));
		result.setOrigen(rs.getString("origen"));
		result.setTipo(rs.getString("tipo"));
		result.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		result.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion"));
		
		return result;
	}

}
