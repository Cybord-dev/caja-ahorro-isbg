package com.business.cybord.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.cybord.models.entities.RolCat;

public interface CatRolRepository extends JpaRepository<RolCat, Integer>{
	
}
