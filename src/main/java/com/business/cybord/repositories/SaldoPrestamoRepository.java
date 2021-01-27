package com.business.cybord.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.SaldoPrestamo;

@Repository
public interface SaldoPrestamoRepository extends JpaRepository<SaldoPrestamo, Integer> {

}
