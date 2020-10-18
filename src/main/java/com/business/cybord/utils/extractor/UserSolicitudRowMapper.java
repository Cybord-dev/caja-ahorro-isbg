package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.composed.UserSolicitudDto;

public class UserSolicitudRowMapper implements RowMapper<UserSolicitudDto> {


	@Override
	public UserSolicitudDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserSolicitudDto result = new UserSolicitudDto();
		result.setNoEmpleado(rs.getInt("no_empleado"));
		result.setId(rs.getInt("id_solicitud"));
		result.setIdUsuario(rs.getInt("id_usuario"));
		result.setNombre(rs.getString("nombre"));
		result.setTipo(rs.getString("tipo_solicitud"));
		result.setFechaCreacion(rs.getDate("fecha_creacion"));
		result.setFechaEjecucion(rs.getDate("fecha_ejecucion"));
		result.setTipoUsuario(rs.getString("tipo_usuario"));
		result.setStatus(rs.getString("estatus"));
		
		return result;
	}

}
