package com.business.cybord.repositories.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.Constants.SqlConstants;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.composed.ReporteSaldosDto;
import com.business.cybord.models.dtos.composed.SaldoAhorroCajaDto;
import com.business.cybord.models.enums.sql.SaldoAhorroFilterEnum;
import com.business.cybord.models.enums.sql.UsuariosFilterEnum;
import com.business.cybord.utils.extractor.ReporteSaldosRowMapper;
import com.business.cybord.utils.extractor.SaldoAhorroCajaAgrupadoRowMapper;
import com.business.cybord.utils.extractor.SaldoAhorroCajaRowMapper;
import com.business.cybord.utils.extractor.SaldoAhorroDtoRowMapper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class ReportesSaldosDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);


	private static final String AHORRO_CAJA_POR_TIPO_ANUAL = "SELECT SUM(monto) as monto, tipo,MONTH(fecha_creacion) as mes  "
			+ "FROM saldo_ahorro where fecha_creacion between ? AND ?  AND validado=1 "
			+ "group by tipo, MONTH(fecha_creacion) Order by fecha_creacion;";

	private static final String AHORRO_CAJA_POR_TIPO_ANUAL_AGRUPADO = "SELECT " + "SUM(monto) monto," + " tipo "
			+ "FROM " + "	saldo_ahorro " + "WHERE validado=1 AND fecha_creacion between ? AND ?" + "GROUP BY tipo;";

	private static final String AHORROS_INTERNOS_LAST_DAYS = "SELECT b.*" + "	FROM "
			+ "		isbg.usuarios 			a," + "		isbg.saldo_ahorro		b" + "	WHERE 1=1"
			+ "		AND a.id_usuario=b.id_usuario" + "	    AND a.tipo_usuario='INTERNO'" + "	    AND b.tipo='ahorro'"
			+ "		AND validado=0 " + "		AND a.ahorrador=1" + "	    AND	b.fecha_creacion>=current_date()-?;";

	private static final String AHORROS_EXTERNOS_LAST_DAYS = "SELECT b.* " + "				FROM   "
			+ "					isbg.usuarios 			a," + "					isbg.saldo_ahorro		b"
			+ "				WHERE 1=1  " + "					AND a.id_usuario=b.id_usuario"
			+ "				    AND a.tipo_usuario='EXTERNO'" + "				    AND b.tipo='ahorro'"
			+ "					AND validado=1" + "					AND a.ahorrador=1"
			+ "				    AND	b.fecha_creacion>=TIMESTAMPADD(DAY,?,CURRENT_TIMESTAMP);";
	
	private static final String SALDO_PRESTAMO_TOTAL = "SELECT SUM(monto) FROM isbg.saldo_ahorro WHERE validado = 1 AND fecha_creacion BETWEEN ? AND ?";


	private static final Logger log = LoggerFactory.getLogger(ReportesSaldosDao.class);

	public List<SaldoAhorroDto> getAhorrosInternosLastDays(int days) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(AHORROS_INTERNOS_LAST_DAYS);
				ps.setInt(1, days);
				return ps;
			}
		}, new SaldoAhorroDtoRowMapper());
	}

	public List<SaldoAhorroDto> getAhorrosExternosLastDays(int days) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(AHORROS_EXTERNOS_LAST_DAYS);
				ps.setInt(1, days);
				return ps;
			}
		}, new SaldoAhorroDtoRowMapper());
	}

	public List<SaldoAhorroCajaDto> getAhorrosCajaAnual(LocalDate start, LocalDate end) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(AHORRO_CAJA_POR_TIPO_ANUAL);
				ps.setDate(1, java.sql.Date.valueOf(start));
				ps.setDate(2, java.sql.Date.valueOf(end));
				return ps;
			}
		}, new SaldoAhorroCajaRowMapper());
	}

	public List<SaldoAhorroCajaDto> getAhorrosCajaAgrupado(LocalDate start, LocalDate end) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(AHORRO_CAJA_POR_TIPO_ANUAL_AGRUPADO);
				ps.setDate(1, java.sql.Date.valueOf(start));
				ps.setDate(2, java.sql.Date.valueOf(end));
				return ps;
			}
		}, new SaldoAhorroCajaAgrupadoRowMapper());
	}

	public Page<ReporteSaldosDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));
		List<ReporteSaldosDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(reportQuery(parameters, pageable));
				return ps;
			}
		}, new ReporteSaldosRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String reportQuery(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusMonths(18).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(new DateTime().plusDays(1).toDate());
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable saldoAhorro = schema.addTable("saldo_ahorro");
		DbTable usuarios = schema.addTable("usuarios");
		DbColumn columnA = new DbColumn(saldoAhorro, "id_usuario", "integer", 0);
		DbColumn columnB = new DbColumn(usuarios, "id_usuario", "integer", 0);
		saldoAhorro.addColumn("fecha_creacion", "String", null);
		saldoAhorro.addColumn("monto", "Double", null);
		saldoAhorro.addColumn("origen", "String", null);
		saldoAhorro.addColumn("tipo", "String", null);
		saldoAhorro.addColumn("observaciones", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("tipo_usuario", "String", null);
		usuarios.addColumn("no_empleado", "String", null);

		SelectQuery selectStoresByParams = new SelectQuery().addFromTable(saldoAhorro)
				.addColumns(saldoAhorro.findColumns("fecha_creacion")).addColumns(saldoAhorro.findColumns("monto"))
				.addColumns(saldoAhorro.findColumns("tipo")).addColumns(usuarios.findColumns("tipo_usuario"))
				.addColumns(saldoAhorro.findColumns("observaciones")).addColumns(usuarios.findColumns("no_empleado"))
				.addColumns(saldoAhorro.findColumns("origen")).addColumns(usuarios.findColumns("nombre"))
				.addJoin(SelectQuery.JoinType.INNER, saldoAhorro, usuarios, BinaryCondition.equalTo(columnA, columnB))
				.addCondition(BinaryCondition.greaterThanOrEq(saldoAhorro.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(saldoAhorro.findColumn("fecha_creacion"), to));

		saldoAhorro.addColumn("validado", "Integer", null);
		selectStoresByParams.addCondition(BinaryCondition.equalTo(saldoAhorro.addColumn("validado"), "1"));

		for (SaldoAhorroFilterEnum sal : SaldoAhorroFilterEnum.values()) {
			if (parameters.containsKey(sal.getParamName())) {
				saldoAhorro.addColumn(sal.getFieldName(), "String", null);
				selectStoresByParams.addCondition(BinaryCondition.equalTo(saldoAhorro.addColumn(sal.getFieldName()),
						parameters.get(sal.getParamName())));
			}
		}

		for (UsuariosFilterEnum sol : UsuariosFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.like(usuarios.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}
		String query = selectStoresByParams.toString().concat(" " + SqlConstants.LIMIT + " " + pageable.getPageSize()
				+ " " + SqlConstants.OFFSET + " " + pageable.getOffset());
		log.info(query);
		return query;
	}

	public String solicitudCount(Map<String, String> parameters) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusMonths(18).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(new DateTime().plusDays(1).toDate());
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable saldoAhorro = schema.addTable("saldo_ahorro");
		DbTable usuarios = schema.addTable("usuarios");
		DbColumn joinColumnA = new DbColumn(saldoAhorro, "id_usuario", "integer", 0);
		DbColumn joinColumnB = new DbColumn(usuarios, "id_usuario", "integer", 0);
		saldoAhorro.addColumn("fecha_creacion", "String", null);

		SelectQuery selectStoresByParams = new SelectQuery().addFromTable(saldoAhorro)
				.addCustomColumns(FunctionCall.countAll())
				.addJoin(SelectQuery.JoinType.INNER, saldoAhorro, usuarios,
						BinaryCondition.equalTo(joinColumnA, joinColumnB))
				.addCondition(BinaryCondition.greaterThanOrEq(saldoAhorro.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(saldoAhorro.findColumn("fecha_creacion"), to));

		saldoAhorro.addColumn("validado", "Integer", null);
		selectStoresByParams.addCondition(BinaryCondition.equalTo(saldoAhorro.addColumn("validado"), "1"));

		for (SaldoAhorroFilterEnum sal : SaldoAhorroFilterEnum.values()) {
			if (parameters.containsKey(sal.getParamName())) {
				saldoAhorro.addColumn(sal.getFieldName(), "String", null);
				selectStoresByParams.addCondition(BinaryCondition.equalTo(saldoAhorro.addColumn(sal.getFieldName()),
						parameters.get(sal.getParamName())));
			}
		}

		for (UsuariosFilterEnum sol : UsuariosFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.like(usuarios.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}
		log.info(selectStoresByParams.toString());
		return selectStoresByParams.toString();
	}

	public BigDecimal getSaldoAhorroTotal(LocalDate fechaInicial, LocalDate fechaFinal) {
		String[] params = new String[]  {
	               fechaInicial.toString(), fechaFinal.toString()};
			return jdbcTemplate.queryForObject(SALDO_PRESTAMO_TOTAL,params, BigDecimal.class);
	}

}
