package com.business.cybord.repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import com.business.cybord.models.dtos.composed.UserAhorroDto;
import com.business.cybord.models.enums.sql.UsuarioAhorroFilterEnum;
import com.business.cybord.utils.extractor.UsuarioAhorroRowMapper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.FunctionCall;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

@Repository
public class UserRepositoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryDao.class);

	public Page<UserAhorroDto> findAll(Map<String, String> parameters, Pageable pageable) {
		int total = jdbcTemplate.queryForObject(solicitudCount(parameters), new Object[] {},
				(rs, rowNum) -> rs.getInt(1));
		List<UserAhorroDto> rows = jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(solicitudQuery(parameters, pageable));
				return ps;
			}
		}, new UsuarioAhorroRowMapper());
		return new PageImpl<>(rows, pageable, total);
	}
	
	public String solicitudQuery(Map<String, String> parameters, Pageable pageable) {
		DbSchema schema = new DbSpec().addDefaultSchema();
		
		DbTable usuarios = schema.addTable("usuarios");
		DbTable datosUsuario = schema.addTable("datos_user");

		DbColumn columnB = new DbColumn(usuarios, "id_usuario", "integer", 0);
		DbColumn columnA = new DbColumn(datosUsuario, "id_usuario", "integer", 0);
		
		datosUsuario.addColumn("dato", "String", null);
		datosUsuario.addColumn("tipo_dato", "String", null);
		usuarios.addColumn("nombre", "String", null);
		usuarios.addColumn("email", "String", null);
		usuarios.addColumn("ahorrador", "String", null);
		usuarios.addColumn("id_usuario", "String", null);
		usuarios.addColumn("estatus", "String", null);
		usuarios.addColumn("tipo_usuario", "String", null);
		usuarios.addColumn("no_empleado", "String", null);
		usuarios.addColumn("tipo_usuario", "String", null);
		usuarios.addColumn("fecha_creacion", "String", null);
		usuarios.addColumn("fecha_actualizacion", "String", null);
		
		SelectQuery select = new SelectQuery().addFromTable(usuarios)
				.addColumns(datosUsuario.findColumns("dato"))
				.addColumns(usuarios.findColumns("tipo_usuario"))
				.addColumns(usuarios.findColumns("id_usuario"))
				.addColumns(usuarios.findColumns("no_empleado"))
				.addColumns(usuarios.findColumns("nombre"))
				.addColumns(usuarios.findColumns("email"))
				.addColumns(usuarios.findColumns("ahorrador"))
				.addColumns(usuarios.findColumns("estatus"))
				.addColumns(usuarios.findColumns("fecha_creacion"))
				.addColumns(usuarios.findColumns("fecha_actualizacion"))
				.addJoin(SelectQuery.JoinType.LEFT_OUTER, usuarios,datosUsuario, BinaryCondition.equalTo(columnA, columnB));
		
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
		String query = select.toString().concat(" " + SqlConstants.LIMIT + " " + pageable.getPageSize()
				+ " " + SqlConstants.OFFSET + " " + pageable.getOffset()).replace("datos_user", "(select * from datos_user WHERE tipo_dato = 'AHORRO')");
		log.info(query);
		return query;
	}
	
	public String solicitudCount(Map<String, String> parameters) {
		DbSchema schema = new DbSpec().addDefaultSchema();
		DbTable usuarios = schema.addTable("usuarios");
		usuarios.addColumn("fecha_creacion", "String", null);

		SelectQuery selectStoresByParams = new SelectQuery().addFromTable(usuarios)
				.addCustomColumns(FunctionCall.countAll());

		for (UsuarioAhorroFilterEnum usuario : UsuarioAhorroFilterEnum.values()) {
			if (parameters.containsKey(usuario.getParamName())) {
				if (usuario.isLikeable()) {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.like(usuarios.addColumn(usuario.getFieldName()),
							"%" + parameters.get(usuario.getParamName()) + "%"));
				} else {
					usuarios.addColumn(usuario.getFieldName(), "String", null);
					selectStoresByParams.addCondition(BinaryCondition.equalTo(usuarios.addColumn(usuario.getFieldName()),
							parameters.get(usuario.getParamName())));
				}
			}
		}

		log.info(selectStoresByParams.toString());
		return selectStoresByParams.toString();
	}
	
}
