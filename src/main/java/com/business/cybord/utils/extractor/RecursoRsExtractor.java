package com.business.cybord.utils.extractor;

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
			result.setTipoArchivo(rs.getString("tipo_archivo"));
			result.setTipoRecurso(rs.getString("tipo_recurso"));
			result.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
			

			byte[] fileData = lobHandler.getBlobAsBytes(rs, "dato");
			result.setDato(new String(fileData,StandardCharsets.UTF_8));

			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

}
