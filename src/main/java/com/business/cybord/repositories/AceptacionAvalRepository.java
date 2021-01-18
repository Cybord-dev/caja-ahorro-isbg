package com.business.cybord.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.AceptacionAval;

@Repository
public interface AceptacionAvalRepository extends JpaRepository<AceptacionAval, Integer> {

	List<AceptacionAval> findByIdSolicitud(Integer idSolicitud);
	
}
