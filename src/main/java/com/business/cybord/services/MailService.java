package com.business.cybord.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.models.config.FileConfig;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.utils.builder.EmailConfigBuilder;
import com.business.cybord.utils.helper.MailHelper;

@Service
public class MailService {
	
	@Autowired
	private MailHelper mailHelper;

	public void sentEmail(String correo,String asunto, String mensaje,FileConfig file) throws IsbgServiceException {
		EmailConfigBuilder emailBuilder = new EmailConfigBuilder()
				.setEmisor("webmaster@siges.com.mx")
				.setPwEmisor("C4ch3t0n_2020*")
				.setAsunto(asunto)
				.addReceptor(correo).setPort("587")
				.setDominio("smtp.gmail.com")
				.setCuerpo(mensaje)
				.addArchivo(file);
			mailHelper.enviarCorreo(emailBuilder.build());
	}
	
	public void sentEmail(String correo,String asunto, String mensaje) throws IsbgServiceException {
		EmailConfigBuilder emailBuilder = new EmailConfigBuilder()
				.setEmisor("webmaster@siges.com.mx")
				.setPwEmisor("C4ch3t0n_2020*")
				.setAsunto(asunto)
				.addReceptor(correo).setPort("587")
				.setDominio("smtp.gmail.com")
				.setCuerpo(mensaje);
			mailHelper.enviarCorreo(emailBuilder.build());
	}

}
