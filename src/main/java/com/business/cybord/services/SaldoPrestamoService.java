package com.business.cybord.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.repositories.dao.SaldoPrestamoDao;

@Service
public class SaldoPrestamoService {

	@Autowired
	private SaldoPrestamoDao dao;

	public Optional<BigDecimal> getSaldoPrestamoInteresByPeriod(String tipoUsuario, LocalDateTime fechaInicial,
			LocalDateTime fechaFinal) {
		return dao.getSaldoPrestamoInteresesByPeriod(tipoUsuario, fechaInicial, fechaFinal);
	}

}
