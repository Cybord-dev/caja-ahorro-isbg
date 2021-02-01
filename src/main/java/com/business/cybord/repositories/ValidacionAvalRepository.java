package com.business.cybord.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.ValidacionAval;

@Repository
public interface ValidacionAvalRepository extends JpaRepository<ValidacionAval, Integer> {

	List<ValidacionAval> findByIdSolicitud(Integer idSolicitud);
	List<ValidacionAval> findByIdUsuarioAvalAndEstatus(String idUsuarioAval,String estatus);
	List<ValidacionAval> findByIdUsuarioAval(String idUsuarioAval);
	
}
