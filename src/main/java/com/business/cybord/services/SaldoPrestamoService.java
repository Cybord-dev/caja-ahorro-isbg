package com.business.cybord.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.models.entities.SaldoPrestamo;
import com.business.cybord.repositories.SaldoAhorroRepository;
import com.business.cybord.repositories.SaldoPrestamoRepository;

@Service
public class SaldoPrestamoService {

	@Autowired
	private SaldoPrestamoRepository repository;

	public List<SaldoPrestamo> getSaldoPrestamoInteresByPeriod(String fechaInicial, String fechaFinal) {
		return repository.getSaldoPrestamoInteresesByPeriod(Date.valueOf(fechaInicial), Date.valueOf(fechaFinal));
	}
	
}
