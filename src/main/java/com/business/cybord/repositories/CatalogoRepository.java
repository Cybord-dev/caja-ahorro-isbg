package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer>{
	Optional<Catalogo> findByTipoAndNombre(String tipo, String nombre);
	List<Catalogo> findByTipo(String tipo);
}
