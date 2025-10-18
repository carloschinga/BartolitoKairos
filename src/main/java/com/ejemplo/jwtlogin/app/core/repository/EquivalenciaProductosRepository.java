package com.ejemplo.jwtlogin.app.core.repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;

@Repository
public class EquivalenciaProductosRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String save(EquivalenciaProductosRequest t) {
		String sql = "EXEC sp_bart_catalogo_precio_equivalencia_save ?,?,?";
		try {
			return jdbcTemplate.queryForObject(sql,
					new Object[] { t.getCodpro(), t.getProductosId(), t.getPresentacionesId() }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

    public String deleteproducto(String codigo) {
        String sql = "EXEC sp_bart_catalogo_precio_equivalencia_delete_codpro ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, String.class);
        } catch (Exception e) {
            // puedes loguear y devolver un JSON vacío o relanzar una excepción custom
            return "{}";
        }
    }

	public String delete(UUID equivalenciaProductosId) {
		String sql = "EXEC sp_bart_catalogo_precio_equivalencia_delete ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { equivalenciaProductosId }, String.class);
		} catch (Exception e) {
			// puedes loguear y devolver un JSON vacío o relanzar una excepción custom
			return "{}";
		}
	}

	public String load() {
		String sql = "EXEC sp_bart_catalogo_precio_equivalencia_listar";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"productos_equivalencia\":[" + String.join(",", cleaned) + "]}";
	}
	
	public String loadKairos() {
		String sql = "EXEC sp_bart_catalogo_precio_equivalencia_listar_productos_kairos";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"productos\":[" + String.join(",", cleaned) + "]}";
	}
	
	public String loadLolfar() {
		String sql = "EXEC sp_bart_catalogo_precio_equivalencia_listar_productos_lolfar";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"productos\":[" + String.join(",", cleaned) + "]}";
	}

}
