package com.business.cybord.services.executors;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.error.IsbgServiceException;

public interface SolicitudExecutor {

	void execute(SolicitudDto solicitudDtos, ValidacionSolicitudDto validacionDto) throws IsbgServiceException;
	void rechazo(SolicitudDto solicitudDtos, ValidacionSolicitudDto validacionDto) throws IsbgServiceException;
	
}
