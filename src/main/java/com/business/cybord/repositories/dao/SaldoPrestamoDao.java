/**
 * 
 */
package com.business.cybord.repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.utils.extractor.SaldoPrestamoRowMapper;

/**
 * @author ralfdemoledor
 *
 */
@Repository
public class SaldoPrestamoDao {

	@Autowired
	private JdbcTemplate template;

	private static final String SELECT_ALL_PRESTAMOS = "SELECT s.id_saldo_prestamo, p.id_prestamo, p.id_deudor, p.monto as monto_prestamo,p.saldo_pendiente,p.estatus, p.no_quincenas, p.tasa_interes, s.tipo, s.origen,s.monto,s.validado, s.fecha_creacion ,s.fecha_actualizacion \n"
			+ "FROM prestamo p INNER JOIN saldo_prestamo s ON p.id_prestamo = s.id_prestamo order by s.fecha_actualizacion";

	private static final String INSERT_SALDO_PRESTAMO = "INSERT INTO isbg.saldo_prestamo"
			+ "(id_prestamo, tipo, monto, validado, origen, fecha_creacion, fecha_actualizacion) VALUES(?, ?, ?, ?, ?, now(), now())";

	private static final String UPDATE_SALDPO_PRESTAMO = "UPDATE isbg.saldo_prestamo SET validado=?, origen=?,fecha_actualizacion= now() WHERE id_saldo_prestamo=?";

	// TODO refactor this method to support paremeters and pagination
	public List<SaldoPrestamoDto> findAllSaldos() {
		return template.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_PRESTAMOS);
				return ps;
			}
		}, new SaldoPrestamoRowMapper());
	}

	public SaldoPrestamoDto insertSaldoPrestamo(SaldoPrestamoDto saldo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SALDO_PRESTAMO);
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

}
