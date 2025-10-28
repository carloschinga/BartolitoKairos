package com.ejemplo.jwtlogin.app.core.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

@Repository
public class TiposCatalogosRepository {

	@Autowired
	@Qualifier("lolfarJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public String saveOrUpdate(TipoCatalogosRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_tipos_catalogos_saveOrUpdate ?,?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getCodtip(), t.getNombtip().toUpperCase() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String load() {
		String sql = "EXEC sp_bart_catalogo_precio_tipos_catalogos_listar";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r)
				.collect(Collectors.toList());

		return "{\"catalogos\":[" + String.join(",", cleaned) + "]}";
	}

	public String getById(Integer codtip) {
		String sql = "EXEC sp_bart_catalogo_precio_tipos_catalogos_get ?";
		List<String> result = jdbcTemplate.queryForList(sql, new Object[] { codtip }, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r)
				.collect(Collectors.toList());

		return "{\"catalogo\":[" + String.join(",", cleaned) + "]}";
	}

	public String delete(Integer codtip) {
		String sql = "EXEC sp_bart_catalogo_precio_tipos_catalogos_delete ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { codtip }, String.class);
		} catch (DataIntegrityViolationException e) {
			return "{\"error\":\"No se puede eliminar. Existen productos asociados a este tipo de catálogo.\"}";
		} catch (Exception e) {
			return "{}";
		}
	}
}
