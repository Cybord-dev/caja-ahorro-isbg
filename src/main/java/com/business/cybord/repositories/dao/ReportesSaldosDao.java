package com.business.cybord.repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.dtos.composed.ReporteSaldosDto;
import com.business.cybord.utils.extractor.ReporteSaldosRowMapper;

@Repository
public class ReportesSaldosDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String REPORTE_SALDO_AHORRO = "select tipo, DATE_FORMAT(FECHA_CREACION,'%Y-%m') fecha,sum(monto) monto " + 
												       "from saldo_ahorro " + 
													   "group by 1,2;";

	private static final Logger log = LoggerFactory.getLogger(ReportesSaldosDao.class);

	public List<ReporteSaldosDto> getReportesBySaldos() {
		log.info("Obteniendo los reportes de saldo ahorro");
		List<ReporteSaldosDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(REPORTE_SALDO_AHORRO);
				return ps;
			}
		}, new ReporteSaldosRowMapper());
		return rows;
	}

}
