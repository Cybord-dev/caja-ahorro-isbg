package com.business.cybord.services.executors;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.error.IsbgServiceException;

public interface SolicitudExecutor {

	void execute(SolicitudDto solicitudDtos, ValidacionDto validacionDto) throws IsbgServiceException;
	void rechazo(SolicitudDto solicitudDtos, ValidacionDto validacionDto) throws IsbgServiceException;
	
}
