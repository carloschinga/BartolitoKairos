package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.laboratorio.LaboratorioFileRequest;

@Repository
public class KairosLaboratoriosRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(LaboratorioFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_kairos_saveOrUpdateFile_laboratorios ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getLaboratoriosId(), t.getDescripcion(), t.getEstado() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}
}
