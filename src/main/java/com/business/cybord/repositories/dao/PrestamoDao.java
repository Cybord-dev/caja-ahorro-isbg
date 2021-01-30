package com.business.cybord.repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.enums.sql.PrestamoFilterEnum;
import com.business.cybord.models.enums.sql.ValidacionAvalFilterEnum;
import com.business.cybord.utils.extractor.PrestamoRowMapper;
import com.business.cybord.utils.helper.DateHelper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class PrestamoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);

	private DateHelper dh = new DateHelper();

	private static final Logger log = LoggerFactory.getLogger(ValidacionAvalDao.class);

	public Page<PrestamoDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));

		List<PrestamoDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query(parameters, pageable));
				return ps;
			}
		}, new PrestamoRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String query(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addDays(new Date(), 2));
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable prestamo = schema.addTable("prestamo");

		prestamo.addColumn("id_prestamo", "String", null);
		prestamo.addColumn("id_deudor", "String", null);
		prestamo.addColumn("id_solicitud", "String", null);
		prestamo.addColumn("estatus", "String", null);
		prestamo.addColumn("no_quincenas", "String", null);
		prestamo.addColumn("tasa_interes", "String", null);
		prestamo.addColumn("monto", "String", null);
		prestamo.addColumn("saldo_pendiente", "String", null);
		prestamo.addColumn("fecha_terminacion", "String", null);
		prestamo.addColumn("fecha_creacion", "String", null);
		prestamo.addColumn("fecha_actualizacion", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(prestamo)
				.addColumns(prestamo.findColumns("id_prestamo"))
				.addColumns(prestamo.findColumns("id_deudor"))
				.addColumns(prestamo.findColumns("id_solicitud"))
				.addColumns(prestamo.findColumns("estatus"))
				.addColumns(prestamo.findColumns("no_quincenas"))
				.addColumns(prestamo.findColumns("tasa_interes"))
				.addColumns(prestamo.findColumns("monto"))
				.addColumns(prestamo.findColumns("saldo_pendiente"))
				.addColumns(prestamo.findColumns("fecha_terminacion"))
				.addColumns(prestamo.findColumns("fecha_creacion"))
				.addColumns(prestamo.findColumns("fecha_actualizacion"))
				.addCondition(BinaryCondition.greaterThanOrEq(prestamo.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(prestamo.findColumn("fecha_creacion"), to));

		for (PrestamoFilterEnum prest : PrestamoFilterEnum.values()) {
			if (parameters.containsKey(prest.getParamName())) {
				prestamo.addColumn(prest.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(prestamo.addColumn(prest.getFieldName()),
						parameters.get(prest.getParamName())));
			}
		}
		log.info(selectByParams.toString());
		return selectByParams.toString();
	}

	public String solicitudCount(Map<String, String> parameters) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addOneDay(new Date()));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable validiacionAval = schema.addTable("validaciones_aval");

		validiacionAval.addColumn("fecha_creacion", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(validiacionAval)
				.addCustomColumns(FunctionCall.countAll())
				.addCondition(BinaryCondition.greaterThanOrEq(validiacionAval.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(validiacionAval.findColumn("fecha_creacion"), to));

		for (ValidacionAvalFilterEnum val : ValidacionAvalFilterEnum.values()) {
			if (parameters.containsKey(val.getParamName())) {
				validiacionAval.addColumn(val.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(validiacionAval.addColumn(val.getFieldName()),
						parameters.get(val.getParamName())));
			}
		}
		log.info(selectByParams.toString());
		return selectByParams.toString();
	}

}
