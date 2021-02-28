package com.business.cybord.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.reports.ReporteAhorroDto;
import com.business.cybord.repositories.dao.reportes.ReporteAhorroDao;

@Service
public class ReportesService {

	@Autowired
	private ReporteAhorroDao reporteAhorroDao;

	public Page<ReporteAhorroDto> getPagedReporteAhorroByFiltros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		Page<ReporteAhorroDto> reporte = reporteAhorroDao.findAll(parameters, PageRequest.of(page, size));
		return reporte;
	}
}
