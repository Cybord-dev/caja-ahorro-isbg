package com.business.cybord.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import org.springframework.stereotype.Repository;

import com.business.cybord.extractor.RecursoRsExtractor;
import com.business.cybord.models.dtos.RecursoDto;


@Repository
public class RecursoRepositoryJDBC {

	@Autowired
	private JdbcTemplate invoiceManagerTemplate;
	
	private static final String FIND_RESOURCE_FILE_BY_RESOURCE_TYPE_AND_REFERENCE = "SELECT * FROM RESOURCES WHERE 1=1 AND referencia = ? AND tipo_referencia = ? ";

	private static final String DELETE_RESOURCE_FILE_BY_RESOURCE_TYPE_AND_REFERENCE = "DELETE FROM RESOURCES WHERE tipo_referencia = ? AND REFERENCIA = ?";
	
	private static final String DELETE_RESOURCE_FILE_BY_ID = "DELETE FROM RESOURCES WHERE id_recurso= ?";

	private static final String INSERT_RESOURCE_FILE = "INSERT INTO RESOURCES (referencia, tipo_referencia, documento, fecha_creacion, fecha_actualizacion) VALUES(?,?,?,?,?)";

	public Optional<RecursoDto> findResourceFileByResourceTypeAndReference(String resource, String reference, String fileType) {
		return invoiceManagerTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(FIND_RESOURCE_FILE_BY_RESOURCE_TYPE_AND_REFERENCE);
				ps.setString(1, fileType);
				ps.setString(2, reference);
				ps.setString(3, resource);

				return ps;
			}
		}, new RecursoRsExtractor());
	}
	
	public int deleteResourceFileByResourceTypeAndReference(String resource, String fileType, String reference) {
		return invoiceManagerTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(DELETE_RESOURCE_FILE_BY_RESOURCE_TYPE_AND_REFERENCE);
				ps.setString(1, resource);
				ps.setString(2, fileType);
				ps.setString(3, reference);
				return ps;
			}
		});
	}
	
	public int deletResourceFileById(int id) {
		return invoiceManagerTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(DELETE_RESOURCE_FILE_BY_ID);
				ps.setInt(1, id);
				return ps;
			}
		});
	}
	

}
