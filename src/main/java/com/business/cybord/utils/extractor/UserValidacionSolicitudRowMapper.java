package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.composed.UserValidacionSolicitudDto;

public class UserValidacionSolicitudRowMapper implements RowMapper<UserValidacionSolicitudDto> {

	@Override
	public UserValidacionSolicitudDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserValidacionSolicitudDto result = new UserValidacionSolicitudDto();
		result.setNoEmpleado(rs.getInt("no_empleado"));
		result.setId(rs.getInt("id_solicitud"));
		result.setIdUsuario(rs.getInt("id_usuario"));
		result.setNombre(rs.getString("nombre"));
		result.setArea(rs.getString("area"));
		result.setTipo(rs.getString("tipo_solicitud"));
		result.setFechaCreacion(rs.getDate("fecha_creacion"));
		result.setTipoUsuario(rs.getString("tipo_usuario"));
		result.setStatus(rs.getString("estatus"));
		result.setAprobada(rs.getString("status"));
		result.setValidador(rs.getString("email"));
		result.setDetalle(rs.getString("estatus_desc"));
		result.setFechaEjecucion(rs.getDate("fecha_ejecucion"));
		return result;
	}

}
