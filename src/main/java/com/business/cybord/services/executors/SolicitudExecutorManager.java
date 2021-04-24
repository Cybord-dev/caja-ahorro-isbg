package com.business.cybord.services.executors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.business.cybord.models.enums.ExecutorManagerEnum;
import com.business.cybord.models.error.IsbgServiceException;

@Component
public class SolicitudExecutorManager {

	@Autowired
	private ConfigurableApplicationContext context;

	public SolicitudExecutor getSolicitudExecutor(String solicitud) throws IsbgServiceException {
		Optional<ExecutorManagerEnum> manager = ExecutorManagerEnum.findByQualifier(solicitud);
		if (manager.isPresent()) {
			return BeanFactoryAnnotationUtils.qualifiedBeanOfType(context.getBeanFactory(), SolicitudExecutor.class,
					manager.get().getQualifier());
		}
		throw new IsbgServiceException("ExecutorManager no se encuentra",
				String.format("No existe el manager executor para la solicitud %s", solicitud),
				HttpStatus.CONFLICT.value());
	}
	
}
