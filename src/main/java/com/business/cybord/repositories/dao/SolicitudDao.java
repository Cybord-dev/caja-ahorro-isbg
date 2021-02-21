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
import com.business.cybord.models.dtos.composed.UserSolicitudDto;
import com.business.cybord.models.enums.sql.SolicitudFilterEnum;
import com.business.cybord.models.enums.sql.UsuariosFilterEnum;
import com.business.cybord.utils.extractor.UserSolicitudRowMapper;
import com.business.cybord.utils.helper.DateHelper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class SolicitudDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DateFormat dateFormat = new SimpleDateFormat(SqlConstants.DATE_FORMAT);
	private DateHelper dh = new DateHelper();

	private static final Logger log = LoggerFactory.getLogger(SolicitudDao.class);

	public Page<UserSolicitudDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));
		List<UserSolicitudDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(solicitudQuery(parameters, pageable));
				return ps;
			}
		}, new UserSolicitudRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String solicitudQuery(Map<String, String> parameters, Pageable pageable) {
		String since = parameters.containsKey(SqlConstants.SINCE) ? parameters.get(SqlConstants.SINCE)
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addDays(new Date(), 2));
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable solicitudes = schema.addTable("solicitudes");
		DbTable usuarios = schema.addTable("usuarios");
		DbColumn columnA = new DbColumn(solicitudes, "id_usuario", "integer", 0);
		DbColumn columnB = new DbColumn(usuarios, "id_usuario", "integer", 0);
		solicitudes.addColumn("fecha_creacion", "String", null);
		solicitudes.addColumn("fecha_ejecucion", "String", null);
		solicitudes.addColumn("id_solicitud", "String", null);
		solicitudes.addColumn("tipo_solicitud", "String", null);
		solicitudes.addColumn("estatus", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("id_usuario", "String", null);
		usuarios.addColumn("tipo_usuario", "String", null);
		usuarios.addColumn("no_empleado", "String", null);

		SelectQuery selectStoresByParams = new SelectQuery().addFromTable(solicitudes)
				.addColumns(solicitudes.findColumns("id_solicitud")).addColumns(solicitudes.findColumns("id_usuario"))
				.addColumns(solicitudes.findColumns("estatus")).addColumns(solicitudes.findColumns("fecha_creacion"))
				.addColumns(solicitudes.findColumns("fecha_ejecucion"))
				.addColumns(solicitudes.findColumns("tipo_solicitud")).addColumns(usuarios.findColumns("tipo_usuario"))
				.addColumns(usuarios.findColumns("id_usuario")).addColumns(usuarios.findColumns("no_empleado"))
				.addColumns(usuarios.findColumns("nombre"))
				.addJoin(SelectQuery.JoinType.INNER, solicitudes, usuarios, BinaryCondition.equalTo(columnA, columnB))
				.addCondition(BinaryCondition.greaterThanOrEq(solicitudes.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(solicitudes.findColumn("fecha_creacion"), to));

		for (SolicitudFilterEnum sol : SolicitudFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				solicitudes.addColumn(sol.getFieldName(), "String", null);
				selectStoresByParams.addCondition(BinaryCondition.equalTo(solicitudes.addColumn(sol.getFieldName()),
						parameters.get(sol.getParamName())));
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
				: dateFormat.format(new DateTime().minusYears(1).toDate());
		String to = parameters.containsKey(SqlConstants.TO) ? parameters.get(SqlConstants.TO)
				: dateFormat.format(dh.addOneDay(new Date()));
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable solicitudes = schema.addTable("solicitudes");
		DbTable usuarios = schema.addTable("usuarios");
		DbColumn joinColumnA = new DbColumn(solicitudes, "id_usuario", "integer", 0);
		DbColumn joinColumnB = new DbColumn(usuarios, "id_usuario", "integer", 0);
		solicitudes.addColumn("fecha_creacion", "String", null);

		SelectQuery selectStoresByParams = new SelectQuery().addFromTable(solicitudes)
				.addCustomColumns(FunctionCall.countAll())
				.addJoin(SelectQuery.JoinType.INNER, solicitudes, usuarios,
						BinaryCondition.equalTo(joinColumnA, joinColumnB))
				.addCondition(BinaryCondition.greaterThanOrEq(solicitudes.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(solicitudes.findColumn("fecha_creacion"), to));

		for (SolicitudFilterEnum sol : SolicitudFilterEnum.values()) {
			if (parameters.containsKey(sol.getParamName())) {
				solicitudes.addColumn(sol.getFieldName(), "String", null);
				selectStoresByParams.addCondition(BinaryCondition.equalTo(solicitudes.addColumn(sol.getFieldName()),
						parameters.get(sol.getParamName())));
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

}
