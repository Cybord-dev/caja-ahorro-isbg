package com.business.cybord.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.SaldoPrestamo;

@Repository
public interface SaldoPrestamoRepository extends JpaRepository<SaldoPrestamo, Integer> {

	@Query("select s from SaldoPrestamo s where s.validado > 0 and s.tipo = 'INTERES' and s.fechaCreacion between :start and :end ")
	public List<SaldoPrestamo> getSaldoPrestamoInteresesByPeriod(@Param("start") Date fechaInicial, @Param("end") Date fechaFinal);

	
}
