package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.entities.CatalogoPropiedad;

@Repository
public interface CatalogoPropiedadRepository extends CrudRepository<CatalogoPropiedad, Integer>{
	Optional<CatalogoPropiedad> findByTipoAndNombre(String tipo, String nombre);
	List<CatalogoPropiedad> findByTipo(String tipo);
}
