/**
 * 
 */
package com.business.cybord.repositories.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.Constants.SqlConstants;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.models.enums.sql.PrestamoFilterEnum;
import com.business.cybord.models.enums.sql.SaldoPrestamoFilterEnum;
import com.business.cybord.models.enums.sql.UsuariosFilterEnum;
import com.business.cybord.utils.extractor.SaldoPrestamoReportRowMapper;
import com.business.cybord.utils.helper.DateHelper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

/**
 * @author ralfdemoledor
 *
 */
@Repository
public class SaldoPrestamoDao {

	@Autowired
	private JdbcTemplate template;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);
	private DateHelper dh = new DateHelper();

	private static final Logger log = LoggerFactory.getLogger(SaldoPrestamoDao.class);

	private static final String INSERT_SALDO_PRESTAMO = "INSERT INTO isbg.saldo_prestamo"
			+ "(id_prestamo, tipo, monto, validado, origen, fecha_creacion, fecha_actualizacion) VALUES(?, ?, ?, ?, ?, now(), now())";

	private static final String UPDATE_SALDPO_PRESTAMO = "UPDATE isbg.saldo_prestamo SET validado=?, origen=?,fecha_actualizacion= now() WHERE id_saldo_prestamo=?";

	private static final String SALDO_PRESTAMO_PERIODO = "SELECT SUM(saldo_prestamo.monto) FROM saldo_prestamo"
									+" INNER JOIN prestamo ON saldo_prestamo.id_prestamo = prestamo.id_prestamo"  
									+" INNER JOIN usuarios ON usuarios.id_usuario = prestamo.id_deudor" 
									+" WHERE saldo_prestamo.tipo = ? AND saldo_prestamo.validado = 1 "
									+ " AND usuarios.tipo_usuario = ? "
									+ " AND saldo_prestamo.fecha_creacion BETWEEN ? AND ? ";

	
	public SaldoPrestamoDto insertSaldoPrestamo(SaldoPrestamoDto saldo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SALDO_PRESTAMO,
						new String[] { "id_saldo_prestamo" });
				ps.setInt(1, saldo.getIdPrestamo());
				ps.setString(2, saldo.getTipo());
				ps.setBigDecimal(3, saldo.getMonto());
				ps.setBoolean(4, Boolean.FALSE);
				ps.setString(5, saldo.getOrigen());
				return ps;
			}
		}, keyHolder);
		saldo.setId(keyHolder.getKey().intValue());
		return saldo;
	}

	public int updateSaldoPrestamo(int id, SaldoPrestamoDto saldo) {

		return template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(UPDATE_SALDPO_PRESTAMO);
				ps.setBoolean(1, saldo.getValidado());
				ps.setString(2, saldo.getOrigen());
				ps.setInt(3, id);
				return ps;
			}
		});
	}

	public Page<SaldoPrestamoDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = template.queryForObject(saldoPrestamoCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));

		List<SaldoPrestamoDto> rows = template.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query(parameters, pageable));
				return ps;
			}
		}, new SaldoPrestamoReportRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String query(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addDays(new Date(), 2));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable saldoPrestamo = schema.addTable("saldo_prestamo");
		DbTable prestamo = schema.addTable("prestamo");
		DbTable usuarios = schema.addTable("usuarios");

		DbColumn joinColumnA = new DbColumn(saldoPrestamo, "id_prestamo", "integer", 0);
		DbColumn joinColumnA2 = new DbColumn(prestamo, "id_prestamo", "integer", 0);
		DbColumn joinColumnB = new DbColumn(prestamo, "id_deudor", "integer", 0);
		DbColumn joinColumnB2 = new DbColumn(usuarios, "id_usuario", "integer", 0);

		saldoPrestamo.addColumn("fecha_creacion", "String", null);
		saldoPrestamo.addColumn("fecha_actualizacion", "String", null);
		saldoPrestamo.addColumn("validado", "String", null);
		saldoPrestamo.addColumn("monto", "String", null);
		saldoPrestamo.addColumn("origen", "String", null);
		saldoPrestamo.addColumn("tipo", "String", null);
		saldoPrestamo.addColumn("id_saldo_prestamo", "String", null);
		saldoPrestamo.addColumn("id_prestamo", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("id_usuario", "String", null);
		usuarios.addColumn("tipo_usuario", "caca", null);
		usuarios.addColumn("no_empleado", "String", null);
		prestamo.addColumn("estatus", "String", null);
		prestamo.addColumn("monto", "String", null);
		prestamo.addColumn("tipo_solicitud", "String", null);
		prestamo.addColumn("tasa_interes", "String", null);
		prestamo.addColumn("id_deudor", "String", null);
		prestamo.addColumn("no_quincenas", "String", null);
		prestamo.addColumn("saldo_pendiente", "String", null);
		prestamo.addColumn("fecha_terminacion", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(saldoPrestamo)
				.addJoin(SelectQuery.JoinType.INNER, saldoPrestamo, prestamo,
						BinaryCondition.equalTo(joinColumnA, joinColumnA2))
				.addJoin(SelectQuery.JoinType.INNER, prestamo, usuarios,
						BinaryCondition.equalTo(joinColumnB, joinColumnB2))
				.addColumns(saldoPrestamo.findColumns("fecha_creacion"))
				.addColumns(saldoPrestamo.findColumns("fecha_actualizacion"))
				.addColumns(saldoPrestamo.findColumns("validado")).addColumns(saldoPrestamo.findColumns("monto"))
				.addColumns(saldoPrestamo.findColumns("origen")).addColumns(saldoPrestamo.findColumns("tipo"))
				.addColumns(saldoPrestamo.findColumns("id_saldo_prestamo"))
				.addColumns(saldoPrestamo.findColumns("id_prestamo")).addColumns(usuarios.findColumns("no_empleado"))
				.addColumns(usuarios.findColumns("nombre")).addColumns(usuarios.findColumns("tipo_usuario"))
				.addColumns(usuarios.findColumns("id_usuario")).addColumns(prestamo.findColumns("estatus"))
				.addColumns(prestamo.findColumns("monto")).addColumns(prestamo.findColumns("no_quincenas"))
				.addColumns(prestamo.findColumns("tasa_interes")).addColumns(prestamo.findColumns("saldo_pendiente"))
				.addColumns(prestamo.findColumns("id_deudor")).addColumns(prestamo.findColumns("fecha_terminacion"))
				.addCondition(BinaryCondition.greaterThanOrEq(saldoPrestamo.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(saldoPrestamo.findColumn("fecha_creacion"), to));

		for (PrestamoFilterEnum prest : PrestamoFilterEnum.values()) {
			if (parameters.containsKey(prest.getParamName())) {
				prestamo.addColumn(prest.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(prestamo.addColumn(prest.getFieldName()),
						parameters.get(prest.getParamName())));
			}
		}

		for (UsuariosFilterEnum sol : UsuariosFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(usuarios.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}

		for (SaldoPrestamoFilterEnum saldoP : SaldoPrestamoFilterEnum.values()) {
			if (parameters.containsKey(saldoP.getParamName())) {
				if (saldoP.isLikeable()) {
					saldoPrestamo.addColumn(saldoP.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(saldoPrestamo.addColumn(saldoP.getFieldName()),
							"%" + parameters.get(saldoP.getParamName()) + "%"));
				} else {
					saldoPrestamo.addColumn(saldoP.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(saldoPrestamo.addColumn(saldoP.getFieldName()),
							parameters.get(saldoP.getParamName())));
				}
			}
		}
		String query = selectByParams.toString().replace("t1.monto,", "t1.monto monto_prestamo,").toString()
				.concat(" " + SqlConstants.LIMIT + " " + pageable.getPageSize() + " " + SqlConstants.OFFSET + " "
						+ pageable.getOffset());
		log.info(query);
		return query;
	}

	public String saldoPrestamoCount(Map<String, String> parameters) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addOneDay(new Date()));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable saldoPrestamo = schema.addTable("saldo_prestamo");
		DbTable prestamo = schema.addTable("prestamo");
		DbTable usuarios = schema.addTable("usuarios");

		DbColumn joinColumnA = new DbColumn(saldoPrestamo, "id_prestamo", "integer", 0);
		DbColumn joinColumnA2 = new DbColumn(prestamo, "id_prestamo", "integer", 0);
		DbColumn joinColumnB = new DbColumn(prestamo, "id_deudor", "integer", 0);
		DbColumn joinColumnB2 = new DbColumn(usuarios, "id_usuario", "integer", 0);
		saldoPrestamo.addColumn("fecha_creacion", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(saldoPrestamo)
				.addCustomColumns(FunctionCall.countAll())
				.addJoin(SelectQuery.JoinType.INNER, saldoPrestamo, prestamo,
						BinaryCondition.equalTo(joinColumnA, joinColumnA2))
				.addJoin(SelectQuery.JoinType.INNER, prestamo, usuarios,
						BinaryCondition.equalTo(joinColumnB, joinColumnB2))
				.addCondition(BinaryCondition.greaterThanOrEq(saldoPrestamo.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(saldoPrestamo.findColumn("fecha_creacion"), to));
		for (PrestamoFilterEnum prest : PrestamoFilterEnum.values()) {
			if (parameters.containsKey(prest.getParamName())) {
				prestamo.addColumn(prest.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(prestamo.addColumn(prest.getFieldName()),
						parameters.get(prest.getParamName())));
			}
		}

		for (UsuariosFilterEnum sol : UsuariosFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(usuarios.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					usuarios.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}

		for (SaldoPrestamoFilterEnum saldoP : SaldoPrestamoFilterEnum.values()) {
			if (parameters.containsKey(saldoP.getParamName())) {
				if (saldoP.isLikeable()) {
					saldoPrestamo.addColumn(saldoP.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(saldoPrestamo.addColumn(saldoP.getFieldName()),
							"%" + parameters.get(saldoP.getParamName()) + "%"));
				} else {
					saldoPrestamo.addColumn(saldoP.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(saldoPrestamo.addColumn(saldoP.getFieldName()),
							parameters.get(saldoP.getParamName())));
				}
			}
		}
		log.info(selectByParams.toString());
		return selectByParams.toString();
	}

	public Optional<BigDecimal> getSaldoPrestamoInteresesByPeriod(String tipoUsuario, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
	
		
		return template.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(SALDO_PRESTAMO_PERIODO);
				ps.setString(1, TipoSaldoPrestamoEnum.INTERES.name());
				ps.setString(2, tipoUsuario);
				ps.setTimestamp(3, Timestamp.valueOf(fechaInicial));
				ps.setTimestamp(4, Timestamp.valueOf(fechaFinal));
				return ps;
			}
		}, new ResultSetExtractor<Optional<BigDecimal>>() {

			@Override
			public Optional<BigDecimal> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				 return rs.next() ? rs.getBigDecimal(1)!= null?Optional.of(rs.getBigDecimal(1)) :Optional.empty() : Optional.empty();
			}
		});
		
	}

	
}
