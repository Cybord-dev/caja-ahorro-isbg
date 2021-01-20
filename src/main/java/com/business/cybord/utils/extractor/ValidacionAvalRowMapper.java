package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.ValidacionAvalDto;

public class ValidacionAvalRowMapper implements RowMapper<ValidacionAvalDto> {

	@Override
	public ValidacionAvalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ValidacionAvalDto result = new ValidacionAvalDto();
		result.setIdSolicitud(rs.getInt("id_solicitud"));
		result.setId(rs.getInt("id"));
		result.setNoEmpleadoAval(rs.getString("no_empleado_aval"));
		result.setNombreDeudor(rs.getString("nombre_deudor"));
		result.setNoEmpleadoDeudor(rs.getString("no_empleado_deudor"));
		result.setEstatus(rs.getString("estatus"));
		result.setComentarios(rs.getString("comentarios"));
		result.setNombreAval(rs.getString("nombre_aval"));
		result.setMontoPrestamo(rs.getBigDecimal("monto_prestamo"));
		result.setFechaCreacion(rs.getDate("fecha_creacion"));
		result.setFechaActualizacion(rs.getDate("fecha_actualizacion"));

		return result;
	}

}
