package com.business.cybord.repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.dtos.composed.UserSolicitudDto;
import com.business.cybord.utils.extractor.UserSolicitudExtractor;

@Repository
public class SolicitudDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Page<UserSolicitudDto> findAll(Pageable pageable) {
		String querySql = "SELECT a.id_solicitud,b.id_usuario,b.nombre,a.tipo_solicitud "
				+ "FROM solicitudes a,usuarios b " + "WHERE a.id_usuario = b.id_usuario " + "LIMIT "
				+ pageable.getPageSize() + " " + "OFFSET " + pageable.getOffset();
		String rowCountSql = "SELECT count(1) AS row_count " + "FROM solicitudes a,usuarios b "
				+ "WHERE a.id_usuario = b.id_usuario ";
		int total = jdbcTemplate.queryForObject(rowCountSql, new Object[] {}, (rs, rowNum) -> rs.getInt(1));

		List<UserSolicitudDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(querySql);
				return ps;
			}
		}, new UserSolicitudExtractor());
		return new PageImpl<>(rows, pageable, total);
	}
}
