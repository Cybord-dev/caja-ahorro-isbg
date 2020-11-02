package com.business.cybord.models.dtos.composed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConciliadorReportDto implements Serializable{

	private static final long serialVersionUID = -2825976281577781669L;
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
