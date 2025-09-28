package com.ejemplo.jwtlogin.app.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.producto.ProductoFileRequest;

@Repository
public class KairosProductosRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(ProductoFileRequest t) {
		String sql = "EXEC sp_bart_kairos_saveOrUpdateFile_productos ?, ?,?,?, ?, ?, ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getProductosId(), t.getLaboratoriosId(),
					t.getDescripcion(), t.getPsicofarmaco(), t.getCodigoVenta(), t.getEstupefaciente(), t.getEstado() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

}
