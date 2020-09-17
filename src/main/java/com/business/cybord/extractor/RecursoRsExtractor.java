package com.business.cybord.extractor;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import com.business.cybord.models.dtos.RecursoDto;

public class RecursoRsExtractor implements ResultSetExtractor<Optional<RecursoDto>> {
	
	@Override
	public Optional<RecursoDto> extractData(ResultSet rs) throws SQLException {
		LobHandler lobHandler = new DefaultLobHandler();
		if (rs.next()) {
			RecursoDto result = new RecursoDto();
			result.setId(rs.getInt("id_recurso"));
			result.setReferencia(rs.getString("referencia"));
			result.setTipoReferencia(rs.getBoolean("tipo_referencia"));
			result.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
			result.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion"));

			byte[] fileData = lobHandler.getBlobAsBytes(rs, "documento");
			result.setDocumento(new String(fileData,StandardCharsets.UTF_8));

			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

}
