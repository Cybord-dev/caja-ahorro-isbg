package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.cybord.models.entities.CatCaja;

public interface CatCajaRepository  extends JpaRepository<CatCaja, Integer>{

	Optional<CatCaja> findByYearAndRango(String year,String rango);
}
