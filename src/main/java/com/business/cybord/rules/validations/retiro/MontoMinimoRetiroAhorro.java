package com.business.cybord.rules.validations.retiro;

import java.math.BigDecimal;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.http.HttpStatus;

import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.error.IsbgServiceException;

@Rule(name = "MontoMinimoRetiroAhorro", description = "Se valida el monto minimo de retiro")
public class MontoMinimoRetiroAhorro {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,@Fact("saldos")List<SaldoAhorroDto> saldos,
			@Fact("results") List<String> results) {
		try {
		if (saldos!=null&&!saldos.isEmpty()&&solicitudDto.getAttributesAsList()!=null&&solicitudDto.getAttributesAsList().stream()
				.anyMatch(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.MONTO.name()))) {
			AtributoSolicitud atributo = solicitudDto.getAttributesAsList().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.MONTO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("No existe el monto en la solicitud",
							"No existe el monto en la solicitud", HttpStatus.CONFLICT.value()));
			BigDecimal monto= new BigDecimal(0);
			for(SaldoAhorroDto dto:saldos) {
				if(dto.getValidado()) {
					monto=monto.add(dto.getMonto());
				}
			}
			return monto.compareTo(new BigDecimal(atributo.getValor()))<0;
		} else {
			return false;
		}
		}catch (IsbgServiceException e) {
			return true;
		}
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El saldo no es suficiente");
	}

}
