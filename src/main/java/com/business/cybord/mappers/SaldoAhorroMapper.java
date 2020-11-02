package com.business.cybord.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.composed.ConciliaSaldoDto;
import com.business.cybord.models.entities.SaldoAhorro;

@Mapper
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaldoAhorroMapper {

	SaldoAhorro getEntityFromDto(SaldoAhorroDto dto);

	SaldoAhorroDto getDtoFromEntity(SaldoAhorro entiti);

	List<SaldoAhorroDto> getDtosFromEntity(List<SaldoAhorro> entities);

	List<SaldoAhorro> getEntitysFromDtos(List<SaldoAhorroDto> dto);

	@Mappings({ @Mapping(source = "idUsuario", target = "idUsuario"),
				@Mapping(source = "monto", target = "saldo"),
				@Mapping(source = "validado", target = "validado"),
				@Mapping(target = "noEmpleado", ignore = true),
				@Mapping(target = "nombre", ignore = true),
				@Mapping(target = "observaciones", ignore = true)})
	ConciliaSaldoDto getConciliaDtoFromSaldo(SaldoAhorroDto dto);

}
