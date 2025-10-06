package com.ejemplo.jwtlogin.app.core.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.producto.ProductoSanitasFileRequest;

@Repository
public class SanitasProductosRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(ProductoSanitasFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_sanitas_saveOrUpdateFile_productos ?,?,?,?,?,?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getCodpro(), t.getProd(), t.getStk(), t.getLab(), t.getDci(), t.getPrec() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String load() {
		String sql = "EXEC sp_bart_catalogo_precio_sanitas_productos_listar";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).toList();

		return "{\"productos\":[" + String.join(",", cleaned) + "]}";
	}

}
