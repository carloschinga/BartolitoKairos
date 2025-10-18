package com.ejemplo.jwtlogin.app.core.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;

@Repository
public class GenericoPreescritoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String load(GenericoPreescritoRequest t) {
		String sql = "EXEC sp_bart_generico_preescrito_listar_completo ?,?";
		List<String> result = jdbcTemplate.queryForList(sql, new Object[] { t.getDesde(), t.getHasta() }, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"genericos\":[" + String.join(",", cleaned) + "]}";
	}

	public String loadProductos(GenericoPreescritoRequest t) {
		String sql = "EXEC sp_bart_generico_preescrito_producto_por_generico ?,?,?";
		List<String> result = jdbcTemplate.queryForList(sql, new Object[] { t.getDesde(), t.getHasta(), t.getGeneId() },
				String.class);

		// Filtra nulls y limpia los corchetes
		List<String> cleaned = result.stream().filter(Objects::nonNull)
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"producto_agrupados\":[" + String.join(",", cleaned) + "]}";
	}

	public String initComboMedico() {
		String sql = "EXEC sp_bart_generico_preescrito_combo_medico";
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		// Une todas las filas en un solo JSON
		List<String> cleaned = result.stream()
				.map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

		return "{\"combo_medico\":[" + String.join(",", cleaned) + "]}";
	}

	public String initComboServicioMedico(GenericoPreescritoComboRequest t) {
		String sql = "EXEC sp_bart_generico_preescrito_combo_servicio_medico ?";
		String json = jdbcTemplate.queryForObject(sql, new Object[] { t.getMedico() }, String.class);

		// En caso de que sea null (por ejemplo, sin resultados)
		if (json == null || json.isBlank()) {
			json = "[]";
		}

		// Limpia los corchetes si SQL devuelve [[...]]
		String cleaned = json.startsWith("[") && json.endsWith("]") ? json.substring(1, json.length() - 1) : json;

		return "{\"combo_servicio_medico\":[" + cleaned + "]}";
	}

	public String initComboDiadesServicioMedico(GenericoPreescritoComboRequest t) {
		String sql = "EXEC sp_bart_generico_preescrito_combo_diades_servicio ?,?";
		String json = jdbcTemplate.queryForObject(sql, new Object[] { t.getServicio(), t.getMedico() }, String.class);

		if (json == null || json.isBlank()) {
			json = "[]";
		}

		String cleaned = json.startsWith("[") && json.endsWith("]") ? json.substring(1, json.length() - 1) : json;

		return "{\"combo_diades\":[" + cleaned + "]}";
	}

}
