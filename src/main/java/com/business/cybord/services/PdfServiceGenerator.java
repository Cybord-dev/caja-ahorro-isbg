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
import com.business.cybord.models.dtos.pdf.SolicitudPdfModelDto;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.utils.PDFGenerator;
import com.business.cybord.utils.helper.FileHelper;

@Service
public class PdfServiceGenerator {

	@Autowired
	private FileHelper fileHelper;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private RecursoService recursoService;

	public String generateSolicitudesAhorroPdf(SolicitudPdfModelDto modelDto, Integer solicitudId)
			throws IsbgServiceException {
		String xmlContent = fileHelper.solicitudXmlToPdf(modelDto);
		InputStreamReader templateReader = new InputStreamReader(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("pdf-config/SolicitudAhorro.xml"));
		Reader inputReader = new StringReader(xmlContent);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		pdfGenerator.render(inputReader, outputStream, templateReader);
		String archivo = Base64.getEncoder().encodeToString(outputStream.toByteArray());
		RecursoDto dto = new RecursoDto(solicitudId.toString(), "PDF", "Solicitud", archivo, new Date());
		recursoService.insertarRecurso(dto);
		return archivo;

	}
}
