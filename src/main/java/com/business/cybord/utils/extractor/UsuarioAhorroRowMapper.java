package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.composed.UserAhorroDto;

public class UsuarioAhorroRowMapper implements RowMapper<UserAhorroDto> {


	@Override
	public UserAhorroDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAhorroDto result = new UserAhorroDto();
		result.setId(rs.getInt("id_usuario"));
		result.setNombre(rs.getString("nombre"));
		result.setEmail(rs.getString("email"));
		result.setAhorrador(rs.getBoolean("ahorrador"));
		result.setNoEmpleado(rs.getString("no_empleado"));
		result.setTipoUsuario(rs.getString("tipo_usuario"));
		if(rs.getString("dato")!=null) {
			result.setMontoAhorro(rs.getString("dato"));
		}
		result.setFechaCreacion(rs.getDate("fecha_creacion"));
		result.setFechaActualizacion(rs.getDate("fecha_actualizacion"));
		
		return result;
	}

}
