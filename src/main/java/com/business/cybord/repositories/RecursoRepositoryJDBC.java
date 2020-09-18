package com.business.cybord.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Repository;

import com.business.cybord.extractor.RecursoRsExtractor;
import com.business.cybord.models.dtos.RecursoDto;


@Repository
public class RecursoRepositoryJDBC {

	@Autowired
	private JdbcTemplate invoiceManagerTemplate;
	
	private static final String BUSCAR_RECURSO_POR_TIPO_RECURSO_Y_TIPO_ARCHIVO_Y_REFERENCIA = "SELECT * FROM RECURSOS WHERE 1=1 AND TIPO_ARCHIVO= ? AND REFERENCIA = ? AND TIPO_RECURSO = ? ";

	private static final String BORRAR_RECURSO_POR_TIPO_RECURSO_Y_TIPO_ARCHIVO_Y_REFERENCIA = "DELETE FROM RECURSOS WHERE TIPO_RECURSO = ? AND TIPO_ARCHIVO= ? AND REFERENCIA = ?";
	
	private static final String BORRAR_RECURSO_POR_ID = "DELETE FROM RECURSOS WHERE id_recurso= ?";

	private static final String INSERTAR_RECURSO = "INSERT INTO RECURSOS (REFERENCIA, TIPO_ARCHIVO, TIPO_RECURSO, DATO, FECHA_CREACION) VALUES(?,?,?,?,?)";

	public Optional<RecursoDto> findResourceFileByResourceTypeAndReference(String tipoRecurso, String referencia, String tipoArchivo) {
		return invoiceManagerTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(BUSCAR_RECURSO_POR_TIPO_RECURSO_Y_TIPO_ARCHIVO_Y_REFERENCIA);
				ps.setString(1, tipoArchivo);
				ps.setString(2, referencia);
				ps.setString(3, tipoRecurso);

				return ps;
			}
		}, new RecursoRsExtractor());
	}
	
	public int deleteResourceFileByResourceTypeAndReference(String resource, String fileType, String reference) {
		return invoiceManagerTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(BORRAR_RECURSO_POR_TIPO_RECURSO_Y_TIPO_ARCHIVO_Y_REFERENCIA);
				ps.setString(1, resource);
				ps.setString(2, fileType);
				ps.setString(3, reference);
				return ps;
			}
		});
	}
	
	public int borrarRecursoPorId(int id) {
		return invoiceManagerTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(BORRAR_RECURSO_POR_ID);
				ps.setInt(1, id);
				return ps;
			}
		});
	}
	
	public int insertarRecurso(RecursoDto dto) {
		return invoiceManagerTemplate.update(INSERTAR_RECURSO,
				new Object[] { dto.getReferencia(), dto.getTipoArchivo(), dto.getTipoRecurso(),
						new SqlLobValue(dto.getDato().getBytes()), new Timestamp(System.currentTimeMillis()) },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB, Types.TIMESTAMP });
	}

	public int updateResourceFile(int id, RecursoDto dto) {
		borrarRecursoPorId(id);
		return insertarRecurso(dto);
	}
	

}
