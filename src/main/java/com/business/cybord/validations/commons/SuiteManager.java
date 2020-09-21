package com.business.cybord.validations.commons;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.business.cybord.models.enums.SolicitudSuitEnum;
import com.business.cybord.validations.suites.ISuite;

@Component
public class SuiteManager {
	
	@Autowired
	private ConfigurableApplicationContext context;

	public ISuite getSolicitudSuiteByName(String suite){
		Optional<SolicitudSuitEnum> suiteManager =SolicitudSuitEnum.findBySuite(suite);
		if (suiteManager.isPresent()) {
			return BeanFactoryAnnotationUtils.qualifiedBeanOfType(context.getBeanFactory(),
					ISuite.class, suiteManager.get().getSuite());
		}
		throw new AssociateServiceException(new AssociateServiceErrorMessage(HttpStatus.BAD_REQUEST.value(),
				RP_INSTANCE_NOT_SUPPORTED, String.format(RP_INSTANCE_NOT_SUPPORTED_BY, rpInstance,
						AssociateLocalTranslator.class.getName())));
	}
	
}
