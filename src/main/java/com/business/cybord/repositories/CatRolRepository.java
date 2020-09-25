package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.cybord.models.entities.RolCat;

public interface CatRolRepository extends JpaRepository<RolCat, Integer>{
	
	Optional<RolCat> getRolByNombre(String nombre);

}