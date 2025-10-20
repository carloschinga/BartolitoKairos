package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.presentacion.PresentacionFileRequest;

@Repository
public class KairosPresentacionesRepository {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
    @Autowired
    @Qualifier("lolfarJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(PresentacionFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_kairos_saveOrUpdateFile_presentaciones ?, ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getPresentacionesId(), t.getProductosId(), t.getDescripcion(), t.getEstado() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}
}
