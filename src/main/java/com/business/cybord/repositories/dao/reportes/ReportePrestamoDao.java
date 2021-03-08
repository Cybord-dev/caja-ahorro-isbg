package com.business.cybord.repositories.dao.reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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
import com.business.cybord.models.dtos.reports.ReportePrestamoDto;
import com.business.cybord.models.enums.sql.PrestamoFilterEnum;
import com.business.cybord.models.enums.sql.UsuarioAhorroFilterEnum;
import com.business.cybord.utils.extractor.reportes.ReportePrestamoRowMapper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class ReportePrestamoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String CASE = "if(t1.estatus ='TRASPASADO', 0, t1.no_quincenas*t1.monto*.01 ) as interes_prestamo";

	private static final String TOTAL = "(SELECT " + "		SUM(C.monto) AS monto" + "	FROM saldo_prestamo C"
			+ "	where t1.id_prestamo=C.id_prestamo" + "		and validado=true) as total_pagado";

	private static final String VALOR = "(SELECT " + "		SUM(C.monto) AS monto " + "	FROM saldo_prestamo C "
			+ "	where t1.id_prestamo=C.id_prestamo" + "		and validado=true"
			+ "	    and fecha_creacion between 'f1' and 'f2'" + "        and tipo='?') as ?";

	private static final Logger log = LoggerFactory.getLogger(ReportePrestamoDao.class);

	public Page<ReportePrestamoDto> findAll(Map<String, String> parameters, LocalDate since, LocalDate to,
			Pageable pageable) {
		int total = jdbcTemplate.queryForObject(count(parameters, since, to), new Object[] {}, (rs, rowNum) -> rs.getInt(1));

		List<ReportePrestamoDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement(query(parameters, since, to, pageable));
			}
		}, new ReportePrestamoRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}

	public String query(Map<String, String> parameters, LocalDate since, LocalDate to, Pageable pageable) {
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable usuarios = schema.addTable("usuarios");
		DbTable prestamo = schema.addTable("prestamo");

		DbColumn columnA = new DbColumn(prestamo, "id_deudor", "integer", 0);
		DbColumn columnB = new DbColumn(usuarios, "id_usuario", "integer", 0);

		usuarios.addColumn("id_usuario", "String", null);
		usuarios.addColumn("tipo_usuario", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("no_empleado", "String", null);

		prestamo.addColumn("id_prestamo", "String", null);
		prestamo.addColumn("estatus", "String", null);
		prestamo.addColumn("interes_prestamo", "String", null);
		prestamo.addColumn("tasa_interes", "String", null);
		prestamo.addColumn("saldo_pendiente", "String", null);
		prestamo.addColumn("interes", "String", null);
		prestamo.addColumn("pagos", "String", null);
		prestamo.addColumn("ajuste", "String", null);
		prestamo.addColumn("total_pagado", "String", null);
		prestamo.addColumn("id_solicitud", "String", null);
		prestamo.addColumn("no_quincenas", "String", null);
		prestamo.addColumn("monto", "String", null);
		prestamo.addColumn("fecha_creacion", "String", null);
		prestamo.addColumn("fecha_actualizacion", "String", null);

		SelectQuery select = new SelectQuery().addFromTable(prestamo)
				.addJoin(SelectQuery.JoinType.INNER,prestamo , usuarios, BinaryCondition.equalTo(columnA, columnB))
				.addColumns(usuarios.findColumns("id_usuario"))
				.addColumns(usuarios.findColumns("tipo_usuario"))
				.addColumns(usuarios.findColumns("nombre"))
				.addColumns(usuarios.findColumns("no_empleado"))
				.addColumns(prestamo.findColumns("tasa_interes"))
				.addColumns(prestamo.findColumns("id_prestamo"))
				.addColumns(prestamo.findColumns("estatus"))
				.addColumns(prestamo.findColumns("interes_prestamo"))
				.addColumns(prestamo.findColumns("saldo_pendiente"))
				.addColumns(prestamo.findColumns("interes"))
				.addColumns(prestamo.findColumns("pagos"))
				.addColumns(prestamo.findColumns("ajuste"))
				.addColumns(prestamo.findColumns("total_pagado"))
				.addColumns(prestamo.findColumns("id_solicitud"))
				.addColumns(prestamo.findColumns("no_quincenas"))
				.addColumns(prestamo.findColumns("monto"))
				.addColumns(prestamo.findColumns("fecha_creacion"))
				.addColumns(prestamo.findColumns("fecha_actualizacion"))
				.addCondition(BinaryCondition.greaterThanOrEq(prestamo.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(prestamo.findColumn("fecha_creacion"), to));
				

		for (UsuarioAhorroFilterEnum usuario : UsuarioAhorroFilterEnum.values()) {
			if (parameters.containsKey(usuario.getParamName())) {
				if (usuario.isLikeable()) {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					select.addCondition(BinaryCondition.like(usuarios.addColumn(usuario.getFieldName()),
							"%" + parameters.get(usuario.getParamName()) + "%"));
				} else {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					select.addCondition(BinaryCondition.equalTo(usuarios.addColumn(usuario.getFieldName()),
							parameters.get(usuario.getParamName())));
				}
			}
		}

		for (PrestamoFilterEnum prest : PrestamoFilterEnum.values()) {
			if (parameters.containsKey(prest.getParamName())) {
				prestamo.addColumn(prest.getFieldName(), "String", null);
				select.addCondition(BinaryCondition.equalTo(prestamo.addColumn(prest.getFieldName()),
						parameters.get(prest.getParamName())));
			}
		}
		String query = select.toString().concat(" " + SqlConstants.LIMIT + " " + pageable.getPageSize() + " "
				+ SqlConstants.OFFSET + " " + pageable.getOffset());
		log.info(query);
		log.info(queryRefactor(query, parameters, since));
		return queryRefactor(query, parameters, since);
	}

	public String count(Map<String, String> parameters,LocalDate since, LocalDate to ) {
		DbSchema schema = new DbSpec().addDefaultSchema();

		DbTable usuarios = schema.addTable("usuarios");
		DbTable prestamo = schema.addTable("prestamo");

		DbColumn columnA = new DbColumn(prestamo, "id_deudor", "integer", 0);
		DbColumn columnB = new DbColumn(usuarios, "id_usuario", "integer", 0);

		SelectQuery selectByParams = new SelectQuery().addFromTable(usuarios).addCustomColumns(FunctionCall.countAll())
				.addJoin(SelectQuery.JoinType.INNER, usuarios, prestamo, BinaryCondition.equalTo(columnA, columnB))
				.addCondition(BinaryCondition.greaterThanOrEq(prestamo.findColumn("fecha_creacion"), since))
				.addCondition(BinaryCondition.lessThanOrEq(prestamo.findColumn("fecha_creacion"), to));

		for (UsuarioAhorroFilterEnum usuario : UsuarioAhorroFilterEnum.values()) {
			if (parameters.containsKey(usuario.getParamName())) {
				if (usuario.isLikeable()) {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.like(usuarios.addColumn(usuario.getFieldName()),
							"%" + parameters.get(usuario.getParamName()) + "%"));
				} else {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					selectByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(usuario.getFieldName()),
							parameters.get(usuario.getParamName())));
				}
			}
		}

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

	private String queryRefactor(String query, Map<String, String> parameters, LocalDate since) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		return query.replace("t1.total_pagado", TOTAL)
				.replace("t1.interes_prestamo", CASE)
				.replace("t1.pagos",
						VALOR.replace("?", "pago").replace("f1", since.format(formatter)).replace("f2",
								LocalDate.now().format(formatter)))
				.replace("t1.ajuste",
						VALOR.replace("?", "ajuste").replace("f1", since.format(formatter)).replace("f2",
								LocalDate.now().format(formatter)))
				.replace("t1.interes", VALOR.replace("?", "interes").replace("f1", since.format(formatter))
						.replace("f2", LocalDate.now().format(formatter)));
	}
}
