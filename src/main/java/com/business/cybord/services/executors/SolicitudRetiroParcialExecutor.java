package com.business.cybord.services.executors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.error.IsbgServiceException;

@Service
@Qualifier("RetiroParcialAhorroSuiteExecutor")
public class SolicitudRetiroParcialExecutor implements SolicitudExecutor {

	@Override
	public SolicitudDto execute(SolicitudDto solicitudDtos) throws IsbgServiceException {
//		TODO Auto-generated method stub
		return solicitudDtos;
	}

}
