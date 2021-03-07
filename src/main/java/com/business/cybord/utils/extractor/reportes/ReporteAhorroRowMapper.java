package com.business.cybord.utils.extractor.reportes;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.business.cybord.models.dtos.reports.ReporteAhorroDto;

public class ReporteAhorroRowMapper  implements RowMapper<ReporteAhorroDto> {
	
	@Override
	public ReporteAhorroDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReporteAhorroDto result = new ReporteAhorroDto();
		result.setAhorro(rs.getBigDecimal("ahorro")!= null ? rs.getBigDecimal("ahorro"): BigDecimal.ZERO);
		result.setAjuste(rs.getBigDecimal("ajuste")!= null ? rs.getBigDecimal("ajuste"): BigDecimal.ZERO);
		result.setInteres(rs.getBigDecimal("interes")!=null ? rs.getBigDecimal("interes"): BigDecimal.ZERO);
		result.setRetiro(rs.getBigDecimal("retiro")!=null ? rs.getBigDecimal("retiro"): BigDecimal.ZERO);
		result.setIdUsuario(rs.getInt("id_usuario"));
		result.setTipoUsuario(rs.getString("tipo_usuario"));
		result.setNoEmpleado(rs.getString("no_empleado"));
		result.setNombre(rs.getString("nombre"));
		result.setTotal(rs.getBigDecimal("total")!= null ? rs.getBigDecimal("total"): BigDecimal.ZERO);
		return result;
	}
	
}
