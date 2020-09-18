package com.business.cybord.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.error.InvoiceManagerException;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.repositories.RecursoRepositoryJDBC;
@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepositoryJDBC repository;
	
	public RecursoDto getRecursoPorTipoRecursoYreferenciaYTipoArchivo(String tipoRecurso, String referencia, String tipoArchivo)
			throws InvoiceManagerException {
		return repository.findResourceFileByResourceTypeAndReference(tipoRecurso,referencia,tipoArchivo).orElseThrow(
				() -> new InvoiceManagerException("El recurso solicitado no existe.", HttpStatus.NOT_FOUND.value()));
	}

	public void insertarRecurso(RecursoDto recurso) {
		Optional<RecursoDto> resource = repository.findResourceFileByResourceTypeAndReference(
				recurso.getTipoRecurso(), recurso.getReferencia(), recurso.getTipoArchivo());
		if (resource.isPresent()) {
			recurso.setId(resource.get().getId());
			repository.updateResourceFile(resource.get().getId(), recurso);
		} else {
			repository.insertarRecurso(recurso);
		}
	}
	
	public void borrarRecurso(Integer id) {
		repository.borrarRecursoPorId(id);
	}
	
	public void deleteResourceFileByResourceReferenceAndType(String resource, String referencia, String type) {
		repository.deleteResourceFileByResourceTypeAndReference(resource, type, referencia);
	}


}
