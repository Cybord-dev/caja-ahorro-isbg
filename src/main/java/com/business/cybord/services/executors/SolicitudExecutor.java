package com.business.cybord.services.executors;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.error.IsbgServiceException;

public interface SolicitudExecutor {
	
	SolicitudDto execute(SolicitudDto solicitudDtos) throws IsbgServiceException ;
	
}
