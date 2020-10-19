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
import com.business.cybord.models.dtos.composed.UserValidacionSolicitudDto;
import com.business.cybord.models.enums.sql.SolicitudFilterEnum;
import com.business.cybord.models.enums.sql.UsuariosFilterEnum;
import com.business.cybord.models.enums.sql.ValdiacionFilterEnum;
import com.business.cybord.utils.DateHelper;
import com.business.cybord.utils.extractor.UserValidacionSolicitudRowMapper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class ValidacionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);
	private DateHelper dh = new DateHelper();

	private static final Logger log = LoggerFactory.getLogger(SolicitudDao.class);

	public Page<UserValidacionSolicitudDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));

		List<UserValidacionSolicitudDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query(parameters, pageable));
				return ps;
			}
		}, new UserValidacionSolicitudRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String query(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addOneDay(new Date()));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable validiacion = schema.addTable("validaciones");
		DbTable solicitudes = schema.addTable("solicitudes");
		DbTable usuarios = schema.addTable("usuarios");

		DbColumn joinColumnA = new DbColumn(validiacion, "id_solicitud", "integer", 0);
		DbColumn joinColumnA2 = new DbColumn(solicitudes, "id_solicitud", "integer", 0);
		DbColumn joinColumnB = new DbColumn(solicitudes, "id_usuario", "integer", 0);
		DbColumn joinColumnB2 = new DbColumn(usuarios, "id_usuario", "integer", 0);
		validiacion.addColumn("fecha_creacion", "String", null);
		validiacion.addColumn("id_validacion", "String", null);
		validiacion.addColumn("email", "String", null);
		validiacion.addColumn("estatus", "String", null);
		validiacion.addColumn("estatus_desc", "String", null);
		validiacion.addColumn("area", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("id_usuario", "String", null);
		usuarios.addColumn("tipo_usuario", "caca", null);
		usuarios.addColumn("no_empleado", "String", null);
		solicitudes.addColumn("fecha_ejecucion", "String", null);
		solicitudes.addColumn("id_solicitud", "String", null);
		solicitudes.addColumn("tipo_solicitud", "String", null);
		solicitudes.addColumn("estatus", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(validiacion)
				.addJoin(SelectQuery.JoinType.INNER, validiacion, solicitudes,
						BinaryCondition.equalTo(joinColumnA, joinColumnA2))
				.addJoin(SelectQuery.JoinType.INNER, solicitudes, usuarios,
						BinaryCondition.equalTo(joinColumnB, joinColumnB2))
				.addColumns(validiacion.findColumns("id_validacion")).addColumns(validiacion.findColumns("email"))
				.addColumns(validiacion.findColumns("estatus")).addColumns(validiacion.findColumns("estatus_desc"))
				.addColumns(validiacion.findColumns("fecha_creacion")).addColumns(validiacion.findColumns("area"))
				.addColumns(usuarios.findColumns("no_empleado")).addColumns(usuarios.findColumns("nombre"))
				.addColumns(usuarios.findColumns("tipo_usuario")).addColumns(usuarios.findColumns("id_usuario"))
				.addColumns(solicitudes.findColumns("id_solicitud")).addColumns(solicitudes.findColumns("estatus"))
				.addColumns(solicitudes.findColumns("tipo_solicitud"))
				.addColumns(solicitudes.findColumns("fecha_ejecucion"))
				.addCondition(BinaryCondition.greaterThanOrEq(validiacion.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(validiacion.findColumn("fecha_creacion"), to));

		for (SolicitudFilterEnum sol : SolicitudFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				solicitudes.addColumn(sol.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(solicitudes.addColumn(sol.getFieldName()),
						parameters.get(sol.getParamName())));
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

		for (ValdiacionFilterEnum sol : ValdiacionFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					validiacion.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(validiacion.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					validiacion.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(validiacion.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}
		log.info(selectByParams.toString().replace("t0.estatus,", "t0.estatus status,"));
		return selectByParams.toString().replace("t0.estatus,", "t0.estatus status,");
	}

	public String solicitudCount(Map<String, String> parameters) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addOneDay(new Date()));
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable validiacion = schema.addTable("validaciones");
		DbTable solicitudes = schema.addTable("solicitudes");
		DbTable usuarios = schema.addTable("usuarios");

		DbColumn joinColumnA = new DbColumn(validiacion, "id_solicitud", "integer", 0);
		DbColumn joinColumnA2 = new DbColumn(solicitudes, "id_solicitud", "integer", 0);
		DbColumn joinColumnB = new DbColumn(solicitudes, "id_usuario", "integer", 0);
		DbColumn joinColumnB2 = new DbColumn(usuarios, "id_usuario", "integer", 0);
		validiacion.addColumn("fecha_creacion", "String", null);

		SelectQuery selectByParams = new SelectQuery().addFromTable(validiacion)
				.addCustomColumns(FunctionCall.countAll())
				.addJoin(SelectQuery.JoinType.INNER, validiacion, solicitudes,
						BinaryCondition.equalTo(joinColumnA, joinColumnA2))
				.addJoin(SelectQuery.JoinType.INNER, solicitudes, usuarios,
						BinaryCondition.equalTo(joinColumnB, joinColumnB2))
				.addCondition(BinaryCondition.greaterThanOrEq(validiacion.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(validiacion.findColumn("fecha_creacion"), to));

		for (SolicitudFilterEnum sol : SolicitudFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				solicitudes.addColumn(sol.getFieldName(), "String", null);
				selectByParams.addCondition(BinaryCondition.equalTo(solicitudes.addColumn(sol.getFieldName()),
						parameters.get(sol.getParamName())));
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

		for (ValdiacionFilterEnum sol : ValdiacionFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				if (sol.isLikeable()) {
					validiacion.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(validiacion.addColumn(sol.getFieldName()),
							"%" + parameters.get(sol.getParamName()) + "%"));
				} else {
					validiacion.addColumn(sol.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(validiacion.addColumn(sol.getFieldName()),
							parameters.get(sol.getParamName())));
				}
			}
		}
		log.info(selectByParams.toString());
		return selectByParams.toString();
	}
}
