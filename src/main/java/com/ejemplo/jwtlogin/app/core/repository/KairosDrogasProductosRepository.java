package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.droga.DrogaProductoFileRequest;

@Repository
public class KairosDrogasProductosRepository {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
    @Autowired
    @Qualifier("lolfarJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(DrogaProductoFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_kairos_saveOrUpdateFile_drogas_productos ?,?,?, ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getDrogasId(), t.getProductosId(), t.getEspecificacionPresentacion(),
							t.getViaAdministracion(), t.getMedioPresentacion(), t.getImportanciaAsociacion() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

}
