package com.ejemplo.jwtlogin.app.core.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosFileRequest;

@Repository
public class OtrosCatalogosRepository {

	@Autowired
	@Qualifier("lolfarJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(ProductoOtrosCatalogosFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_otros_catalogos_saveOrUpdateFile_productos ?,?,?,?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getCodpro(), t.getProd(), t.getPrec(), t.getCodtip() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String save(ProductoOtrosCatalogosFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_otros_catalogos_save ?, ?, ?";
		try {
			jdbcTemplate.update(sql, t.getCodpro(), t.getPrec(), t.getCodtip());
			return "OK";
		} catch (DuplicateKeyException e) {
			return "DUPLICADO";
		} catch (DataAccessException e) {
			System.err.println("Error de base de datos: " + e.getMessage());
			return "ERROR_DB";
		} catch (Exception e) {
			System.err.println("Error general: " + e.getMessage());
			return "ERROR";
		}
	}

	public String update(ProductoOtrosCatalogosFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_otros_catalogos_update ?,?,?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getCodpro(), t.getPrec(), t.getCodtip() },
					String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String delete(ProductoOtrosCatalogosFileRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_otros_catalogos_delete ?,?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getCodpro(), t.getCodtip() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String load(TiposCatalogosRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_otros_catalogos_productos_listar ?";
		List<String> result = jdbcTemplate.queryForList(sql, new Object[] { t.getCodtip() }, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r)
				.collect(Collectors.toList());

		return "{\"productos\":[" + String.join(",", cleaned) + "]}";
	}

	public String initComboCatalogos() {
		String sql = "EXEC sp_bart_catalogo_precio_tipos_catalogos_combo";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r)
				.collect(Collectors.toList());

		return "{\"catalogos\":[" + String.join(",", cleaned) + "]}";
	}

}
