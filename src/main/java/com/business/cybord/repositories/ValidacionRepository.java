package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.Validacion;

@Repository
public interface ValidacionRepository  extends JpaRepository<Validacion, Integer>{
	
	List<Validacion> findBySolicitud(Solicitud dto);
	
	@Query("select v from Validacion as v where v.solicitud.id=:idU")
	List<Validacion> findByIdSolicitud(@Param("idU") Integer idU);
	
	Optional<Validacion> findById(int id);
}
