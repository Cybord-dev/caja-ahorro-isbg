package com.business.cybord.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.repositories.dao.SaldoPrestamoDao;

@Service
public class SaldoPrestamoService {

	
	@Autowired
	private SaldoPrestamoDao dao;

	public BigDecimal getSaldoPrestamoInteresByPeriod(LocalDate fechaInicial, LocalDate fechaFinal) {
		return dao.getSaldoPrestamoInteresesByPeriod(fechaInicial, fechaFinal);
	}
	
}
