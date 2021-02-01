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
import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.models.enums.sql.ValidacionAvalFilterEnum;
import com.business.cybord.utils.extractor.ValidacionAvalRowMapper;
import com.business.cybord.utils.helper.DateHelper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class ValidacionAvalDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);

	private DateHelper dh = new DateHelper();

	private static final Logger log = LoggerFactory.getLogger(ValidacionAvalDao.class);

	public Page<ValidacionAvalDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));

		List<ValidacionAvalDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query(parameters, pageable));
				return ps;
			}
		}, new ValidacionAvalRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String query(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addDays(new Date(), 2));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable validiacionAval = schema.addTable("validaciones_aval");

		validiacionAval.addColumn("fecha_creacion", "String", null);
		validiacionAval.addColumn("id_solicitud", "String", null);
		validiacionAval.addColumn("id", "String", null);
		validiacionAval.addColumn("id_usuario_aval", "String", null);
		validiacionAval.addColumn("nombre_deudor", "String", null);
		validiacionAval.addColumn("id_usuario_deudor", "String", null);
		validiacionAval.addColumn("estatus", "String", null);
		validiacionAval.addColumn("comentarios", "String", null);
		validiacionAval.addColumn("fecha_creacion", "String", null);
		validiacionAval.addColumn("fecha_actualizacion", "String", null);
		validiacionAval.addColumn("monto_prestamo", "String", null);
		validiacionAval.addColumn("nombre_aval", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(validiacionAval)
				.addColumns(validiacionAval.findColumns("fecha_creacion")).addColumns(validiacionAval.findColumns("id"))
				.addColumns(validiacionAval.findColumns("id_solicitud"))
				.addColumns(validiacionAval.findColumns("id_usuario_aval"))
				.addColumns(validiacionAval.findColumns("nombre_deudor"))
				.addColumns(validiacionAval.findColumns("id_usuario_deudor"))
				.addColumns(validiacionAval.findColumns("estatus"))
				.addColumns(validiacionAval.findColumns("comentarios"))
				.addColumns(validiacionAval.findColumns("fecha_creacion"))
				.addColumns(validiacionAval.findColumns("fecha_actualizacion"))
				.addColumns(validiacionAval.findColumns("monto_prestamo"))
				.addColumns(validiacionAval.findColumns("nombre_aval"))
				.addCondition(BinaryCondition.greaterThanOrEq(validiacionAval.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(validiacionAval.findColumn("fecha_creacion"), to));
		for (ValidacionAvalFilterEnum val : ValidacionAvalFilterEnum.values()) {
			if (parameters.containsKey(val.getParamName())) {
				validiacionAval.addColumn(val.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(validiacionAval.addColumn(val.getFieldName()),
						parameters.get(val.getParamName())));
			}
		}
		String query = selectByParams.toString().concat(" " + SqlConstants.LIMIT + " " + pageable.getPageSize() + " "
				+ SqlConstants.OFFSET + " " + pageable.getOffset());
		log.info(query);
		return query;
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
