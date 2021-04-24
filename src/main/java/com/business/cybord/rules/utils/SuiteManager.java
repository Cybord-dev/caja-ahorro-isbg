package com.business.cybord.rules.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.business.cybord.models.enums.SolicitudSuitEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.rules.suites.ISuite;

@Component
public class SuiteManager {

	@Autowired
	private ConfigurableApplicationContext context;

	public ISuite getSolicitudSuite(String suite) throws IsbgServiceException {
		Optional<SolicitudSuitEnum> suiteManager = SolicitudSuitEnum.findBySuite(suite);
		if (suiteManager.isPresent()) {
			return BeanFactoryAnnotationUtils.qualifiedBeanOfType(context.getBeanFactory(), ISuite.class,
					suiteManager.get().getSuite());
		}
		throw new IsbgServiceException("El recurso solicitado no existe.", "La solicitud no  existe",HttpStatus.CONFLICT.value());
	}

}
