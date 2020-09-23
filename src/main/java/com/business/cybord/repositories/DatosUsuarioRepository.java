package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.business.cybord.entities.DatosUsuario;



@Repository
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Integer> {
	

	public Optional<DatosUsuario> findById(String id);
	
	public List<DatosUsuario> findByIdUsuario(Integer id);
	
	public Optional<DatosUsuario> findByTipoDato(String tipoDato);

	public Optional<DatosUsuario> findByTipoDatoAndIdUsuario(String tipoDato,Integer id);
}

