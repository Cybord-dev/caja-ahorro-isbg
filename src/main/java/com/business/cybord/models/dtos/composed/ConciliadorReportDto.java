package com.business.cybord.models.dtos.composed;

import java.util.ArrayList;
import java.util.List;

public class ConciliadorReportDto {

	private List<ConciliaSaldoDto> correctos;
	private List<ConciliaSaldoDto> errores;

	public ConciliadorReportDto() {
		correctos = new ArrayList<ConciliaSaldoDto>();
		errores = new ArrayList<ConciliaSaldoDto>();
	}

	public void addError(ConciliaSaldoDto a) {
		errores.add(a);
	}

	public void addcorrecto(ConciliaSaldoDto a) {
		correctos.add(a);
	}

	public List<ConciliaSaldoDto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(List<ConciliaSaldoDto> correctos) {
		this.correctos = correctos;
	}

	public List<ConciliaSaldoDto> getErrores() {
		return errores;
	}

	public void setErrores(List<ConciliaSaldoDto> errores) {
		this.errores = errores;
	}

	@Override
	public String toString() {
		return "ConciliadorReportDto []";
	}

}
