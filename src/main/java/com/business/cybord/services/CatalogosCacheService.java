package com.business.cybord.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.models.entities.Catalogo;
import com.business.cybord.repositories.CatalogoRepository;

@Service
public class CatalogosCacheService {

	@Autowired
	private CatalogoRepository repository;

	private Map<String, Catalogo> catalogos;

	private static final Logger log = LoggerFactory.getLogger(CatalogosCacheService.class);

	@PostConstruct
	public void init() {
		log.info("Loading mappings");
		loadCatalogos();
		log.info("Mappings catalogos loaded {}", catalogos.size());
	}

	private void loadCatalogos() {
		catalogos = new HashMap<>();
		for (Catalogo clave : repository.findAll()) {
			catalogos.put(clave.getNombre(), clave);
		}
	}

	public Optional<String> getCatalogo(String clave) {
		return catalogos.containsKey(clave) ? Optional.of(catalogos.get(clave).getValor()) : Optional.empty();
	}
}
