package com.ejemplo.jwtlogin.app.core.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.core.repository.GenericoPreescritoRepository;
import com.ejemplo.jwtlogin.app.core.service.GenericoPreescritoService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;

@Service
public class GenericoPreescritoServiceImpl extends ServiceBase implements GenericoPreescritoService {

    @Autowired
    private GenericoPreescritoRepository genericoPreescritoRepository;

    @Override
    public JSONArray load(GenericoPreescritoRequest t) {
        String response = genericoPreescritoRepository.load(t);
        JSONObject obj = new JSONObject(response);
        return obj.getJSONArray("genericos");
    }

    @Override
    public JSONArray initComboMedico() {
        String response = genericoPreescritoRepository.initComboMedico();
        JSONObject obj = new JSONObject(response);
        return obj.getJSONArray("combo_medico");
    }

    @Override
    public JSONArray initComboServicioMedico(GenericoPreescritoComboRequest t) {
        String response = genericoPreescritoRepository.initComboServicioMedico(t);
        JSONObject obj = new JSONObject(response);
        return obj.getJSONArray("combo_servicio_medico");
    }

    @Override
    public JSONArray initComboDiadesServicioMedico(GenericoPreescritoComboRequest t) {
        String response = genericoPreescritoRepository.initComboDiadesServicioMedico(t);
        JSONObject obj = new JSONObject(response);
        return obj.getJSONArray("combo_diades");
    }

    @Override
    public JSONArray loadProductos(GenericoPreescritoRequest t) {
        String response = genericoPreescritoRepository.loadProductos(t);
        JSONObject obj = new JSONObject(response);
        return obj.getJSONArray("producto_agrupados");
    }

}
