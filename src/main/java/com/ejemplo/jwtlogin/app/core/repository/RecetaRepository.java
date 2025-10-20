package com.ejemplo.jwtlogin.app.core.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class RecetaRepository {

    @Autowired
    @Qualifier("lolfarJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("biJdbcTemplate")
    private JdbcTemplate biJdbcTemplate;

    /**
     * Lista todos los médicos.
     */
    public String listarMedicos() {
        String sql = "EXEC sp_bart_receta_medicos_listar";
        try {
            return jdbcTemplate.queryForObject(sql, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"resultado\":\"error\",\"mensaje\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Lista todos los servicios.
     */
    public String listarServicios() {
        String sql = "EXEC sp_bart_receta_servicios_listar";
        try {
            return jdbcTemplate.queryForObject(sql, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"resultado\":\"error\",\"mensaje\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Lista médicos por servicios seleccionados.
     */
    public String listarMedicosPorServicios(List<String> servicios) {
        // Convertir lista en XML
        StringBuilder xml = new StringBuilder("<Registros>");
        for (String s : servicios) {
            xml.append("<Registro>").append(s).append("</Registro>");
        }
        xml.append("</Registros>");

        String sql = "EXEC sp_bart_receta_medicosxespecialidad_listar ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{xml.toString()}, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"resultado\":\"error\",\"mensaje\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Lista diagnósticos por rango de fechas, paciente, servicios y médicos.
     */

    public String listarDiagnosticos(String paciente, List<String> servicios, List<String> medicos, LocalDate fechaInicio, LocalDate fechaFin) {

        // Convertir lista de servicios a XML
        StringBuilder xmlServicios = new StringBuilder("<Registros>");
        for (String s : servicios) {
            xmlServicios.append("<Registro>").append(s).append("</Registro>");
        }
        xmlServicios.append("</Registros>");

        // Convertir lista de médicos a XML
        StringBuilder xmlMedicos = new StringBuilder("<Registros>");
        for (String m : medicos) {
            xmlMedicos.append("<Registro>").append(m).append("</Registro>");
        }
        xmlMedicos.append("</Registros>");

        String sql = "EXEC select_diagnostico ?, ?, ?, ?, ?";

        try {
            List<Map<String,Object>> rows = biJdbcTemplate.queryForList(
                    sql,
                    xmlServicios.toString(),
                    paciente,
                    xmlMedicos.toString(),
                    Date.valueOf(fechaInicio),
                    Date.valueOf(fechaFin)
            );

            // Convertir a JSONArray
            JSONArray jsonArray = new JSONArray();
            for(Map<String,Object> row : rows){
                JSONObject obj = new JSONObject();
                obj.put("FechaAtencion", row.get("FechaAtencion"));
                obj.put("ActoMedico", row.get("ActoMedico"));
                obj.put("Prefactura", row.get("Prefactura"));
                obj.put("Servicio", row.get("Servicio"));
                obj.put("Medico", row.get("Medico"));
                obj.put("Paciente", row.get("Paciente"));
                obj.put("TelfPac", row.get("TelfPac"));
                obj.put("PlanAtencion", row.get("PlanAtencion"));
                obj.put("cantimpr", row.get("cantimpr"));
                jsonArray.put(obj);
            }

            return jsonArray.toString();

        } catch(Exception e){
            e.printStackTrace();
            return "[]"; // JSONArray vacío en caso de error
        }
    }
}
