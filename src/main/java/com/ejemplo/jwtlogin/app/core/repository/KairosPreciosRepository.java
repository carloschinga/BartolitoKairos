package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.precio.PrecioFileRequest;

@Repository
public class KairosPreciosRepository {
	@Autowired
	@Qualifier("lolfarJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(PrecioFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_kairos_saveOrUpdateFile_precios ?,?, ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getProductosId(), t.getPresentacionesId(),
					t.getPrecioFabrica(), t.getPrecioPublico(), t.getFechaVigencia() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}
}
