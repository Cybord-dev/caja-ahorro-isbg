package com.business.cybord.services;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.enums.TipoPdfEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.utils.PDFGenerator;

@Service
public class PdfServiceGenerator {

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private RecursoService recursoService;

	public String generateSolicitudesAhorroPdf(TipoPdfEnum pdfFile, String xmlContent, Integer solicitudId)
			throws IsbgServiceException {
		String file = "pdf-config/";
		InputStreamReader templateReader = new InputStreamReader(
				Thread.currentThread().getContextClassLoader().getResourceAsStream(file.concat(pdfFile.getFile())));
		Reader inputReader = new StringReader(xmlContent);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		pdfGenerator.render(inputReader, outputStream, templateReader);
		String archivo = Base64.getEncoder().encodeToString(outputStream.toByteArray());
		RecursoDto dto = new RecursoDto(solicitudId.toString(), "PDF", "Solicitud", archivo, new Date());
		recursoService.insertarRecurso(dto);
		return archivo;

	}
}
