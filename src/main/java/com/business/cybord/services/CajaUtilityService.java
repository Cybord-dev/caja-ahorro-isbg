package com.business.cybord.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.CatalogoMapper;
import com.business.cybord.models.dtos.CatCajaDto;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.CatCajaRepository;

@Service
public class CajaUtilityService {

	@Autowired
	private CatCajaRepository repository;

	@Autowired
	private CatalogoMapper mapper;

	private static final DateFormat yearFormat = new SimpleDateFormat("YYYY");
	private static final DateFormat monthFormat = new SimpleDateFormat("mm");

	public CatCajaDto getCurrentCaja() throws IsbgServiceException {
		Date fecha = new Date();
		System.out.println(fecha);
		String year = yearFormat.format(fecha);
		String mes = monthFormat.format(fecha);
		String rango = "1";
		if (Integer.parseInt(mes) >= 11) {
			rango = "2";
		}
		return mapper.getCatCajaDtoFromEntidad(repository.findByYearAndRango(year, rango)
				.orElseThrow(() -> new IsbgServiceException("No existe la configuracion de la caja en el catalogo",
						"No existe la configuracion de la caja en el catalogo", HttpStatus.CONFLICT.value())));
	}

}
