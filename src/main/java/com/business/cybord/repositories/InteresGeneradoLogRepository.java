package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.cybord.models.entities.InteresGeneradoLog;


public interface InteresGeneradoLogRepository extends JpaRepository<InteresGeneradoLog, Integer> {

	
	public Optional<InteresGeneradoLog> findFirstByOrderByFechaEjecucionDesc();
	
	
}
