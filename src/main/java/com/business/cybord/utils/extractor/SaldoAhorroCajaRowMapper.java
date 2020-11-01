package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.composed.SaldoAhorroCajaDto;

public class SaldoAhorroCajaRowMapper implements RowMapper<SaldoAhorroCajaDto> {

	@Override
	public SaldoAhorroCajaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaldoAhorroCajaDto result = new SaldoAhorroCajaDto();
		result.setMes(rs.getString("mes"));
		result.setMonto(rs.getBigDecimal("monto"));
		result.setTipo(rs.getString("tipo"));
		return result;
	}

}
