package com.business.cybord.services;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CajaUtilityService {

	@Autowired
	private  CatalogoService catService;

	private static final String CAT_TYPE = "configuraciones";
	private static final String CONF_TYPE = "INICIO-CAJA";

	public LocalDate getInicioCajaActual() {
		
		LocalDate today = LocalDate.now();
		
		Month monthStart = Month.valueOf(catService.getCatPropiedadByTipoAndNombre(CAT_TYPE, CONF_TYPE).getValor());
		
		if(today.getMonth().compareTo(monthStart)>=0) {
			return LocalDate.of(today.getYear(), monthStart.getValue(),1);
		}else {
			return LocalDate.of(today.getYear()-1, monthStart.getValue(),1);
		}
	}
	
	public LocalDate getFinCajaActual() {
		
		LocalDate today = LocalDate.now();
		
		Month monthStart = Month.valueOf(catService.getCatPropiedadByTipoAndNombre(CAT_TYPE, CONF_TYPE).getValor());
		
		if(today.getMonth().compareTo(monthStart)>=0) {
			return LocalDate.of(today.getYear()+1, monthStart.getValue(),1);
		}else {
			return LocalDate.of(today.getYear(), monthStart.getValue(),1);
		}
	}

}
