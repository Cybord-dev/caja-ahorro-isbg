package com.business.cybord.utils.helper;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.business.cybord.models.dtos.pdf.SolicitudPdfModelDto;
import com.business.cybord.models.dtos.pdf.SolicitudPrestamoPdfModelDto;
import com.business.cybord.models.error.IsbgServiceException;

public class FileHelper {

	public String solicitudXmlToPdf(SolicitudPdfModelDto modelDto) throws IsbgServiceException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SolicitudPdfModelDto.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(modelDto, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IsbgServiceException(e.getMessage());
		}

	}

	public String solicitudPrestamoXmlToPdf(SolicitudPrestamoPdfModelDto modelDto) throws IsbgServiceException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SolicitudPrestamoPdfModelDto.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(modelDto, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IsbgServiceException(e.getMessage());
		}

	}

}
