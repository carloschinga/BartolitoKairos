package com.ejemplo.jwtlogin.app.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;

@Repository
public class GenericoPreescritoRepository {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
    @Autowired
    @Qualifier("biJdbcTemplate")
    private JdbcTemplate biJdbcTemplate;

    public String load(GenericoPreescritoRequest t) {
        String sql = "EXEC sp_bart_generico_preescrito_listar_completo ?,?";
        List<String> result = biJdbcTemplate.queryForList(sql, new Object[] { t.getDesde(), t.getHasta() }, String.class);
        // Une todas las filas en un solo JSON
        List<String> cleaned = result.stream()
                .map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

        return "{\"genericos\":[" + String.join(",", cleaned) + "]}";
    }

    public String loadProductos(GenericoPreescritoRequest t) {
        String sql = "EXEC sp_bart_generico_preescrito_producto_por_generico ?,?,?";
        List<String> result = biJdbcTemplate.queryForList(sql, new Object[] { t.getDesde(), t.getHasta(), t.getGeneId() },
                String.class);

        // Filtra nulls y limpia los corchetes
        List<String> cleaned = result.stream().filter(Objects::nonNull)
                .map(r -> r.startsWith("[") && r.endsWith("]") ? r.substring(1, r.length() - 1) : r).collect(Collectors.toList());

        return "{\"producto_agrupados\":[" + String.join(",", cleaned) + "]}";
    }

    public String initComboMedico(GenericoPreescritoComboRequest t) {
    	
    	String jsonServicios = new JSONArray(t.getServicio() != null ? t.getServicio() : new ArrayList<>()).toString();
    	String jsonDiades = new JSONArray(t.getDiades() != null ? t.getDiades() : new ArrayList<>()).toString();
    	
        String sql = "EXEC sp_bart_generico_preescrito_combo_medico ?,?";
        String json = biJdbcTemplate.queryForObject(sql, new Object[] { jsonServicios, jsonDiades }, String.class);

        if (json == null || json.isBlank()) json = "[]";
        String cleaned = json.startsWith("[") && json.endsWith("]") ? json.substring(1, json.length() - 1) : json;
        return "{\"combo_medico\":[" + cleaned + "]}";

    }

    public String initComboServicioMedico(GenericoPreescritoComboRequest t) {
    	
    	String jsonMedicos = new JSONArray(t.getMedico() != null ? t.getMedico() : new ArrayList<>()).toString();
    	String jsonDiades = new JSONArray(t.getDiades() != null ? t.getDiades() : new ArrayList<>()).toString();
    	
        String sql = "EXEC sp_bart_generico_preescrito_combo_servicio_medico ?, ?";
        String json = biJdbcTemplate.queryForObject(sql, new Object[] { jsonMedicos, jsonDiades }, String.class);

        if (json == null || json.isBlank()) json = "[]";
        String cleaned = json.startsWith("[") && json.endsWith("]") ? json.substring(1, json.length() - 1) : json;
        return "{\"combo_servicio_medico\":[" + cleaned + "]}";
    }

    public String initComboDiadesServicioMedico(GenericoPreescritoComboRequest t) {
    	
    	String jsonMedicos = new JSONArray(t.getMedico() != null ? t.getMedico() : new ArrayList<>()).toString();
    	String jsonServicios = new JSONArray(t.getServicio() != null ? t.getServicio() : new ArrayList<>()).toString();
    	
        String sql = "EXEC sp_bart_generico_preescrito_combo_diades_servicio ?,?";
        String json = biJdbcTemplate.queryForObject(sql, new Object[] { jsonServicios, jsonMedicos }, String.class);

        if (json == null || json.isBlank()) json = "[]";
        String cleaned = json.startsWith("[") && json.endsWith("]") ? json.substring(1, json.length() - 1) : json;
        return "{\"combo_diades\":[" + cleaned + "]}";        
    }

}
