package com.business.cybord.utils.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.business.cybord.models.dtos.composed.UserSolicitudDto;

public class UserSolicitudExtractor implements ResultSetExtractor<List<UserSolicitudDto>> {

	@Override
	public List<UserSolicitudDto> extractData(ResultSet rs) throws SQLException {
		List<UserSolicitudDto> registros = new ArrayList<>();
		while (rs.next()) {
			UserSolicitudDto result = new UserSolicitudDto();
			result.setNoEmpleado(rs.getInt("no_empleado"));
			result.setIdUser(rs.getInt("id_solicitud"));
			result.setNombre(rs.getString("nombre"));
			result.setTipo(rs.getString("tipo_solicitud"));
			result.setFechaSolicitud(rs.getDate("fecha_creacion"));
			result.setTipoUsuario(rs.getString("tipo_usuario"));
			result.setStatusSolicitud(rs.getString("estatus"));
			registros.add(result);
			
		}
		return registros;
	}

}
