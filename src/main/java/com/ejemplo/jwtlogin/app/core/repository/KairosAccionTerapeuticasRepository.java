package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.accionTerapeutica.AccionTerapeuticaFileRequest;

@Repository
public class KairosAccionTerapeuticasRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(AccionTerapeuticaFileRequest t) {
		String sql = "EXEC sp_bart_kairos_saveOrUpdateFile_accion_terapeuticas ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getAccionTerapeuticasId(), t.getDescripcion(), t.getEstado() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	
}
