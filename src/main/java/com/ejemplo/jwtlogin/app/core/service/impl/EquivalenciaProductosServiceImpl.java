package com.ejemplo.jwtlogin.app.core.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.core.repository.EquivalenciaProductosRepository;
import com.ejemplo.jwtlogin.app.core.service.EquivalenciaProductosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;

@Service
public class EquivalenciaProductosServiceImpl extends ServiceBase implements EquivalenciaProductosService {

	@Autowired
	private EquivalenciaProductosRepository equivalenciaProductosRepository;

	@Override
	public void save(EquivalenciaProductosRequest t) {
		equivalenciaProductosRepository.save(t);
	}

	@Override
	public void delete(UUID equivalenciaProductosId) {
		equivalenciaProductosRepository.delete(equivalenciaProductosId);
	}

    @Override
    public void deleteproducto(String codigo) {
        equivalenciaProductosRepository.deleteproducto(codigo);
    }

    @Override
    public List<EquivalenciaProductosResponse> loadEquivalencias() {
        return equivalenciaProductosRepository.loadEquivalencias();
    }

	/*@Override
	public JSONArray load() {
		String response = equivalenciaProductosRepository.load();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("productos_equivalencia");
	}*/


	@Override
	public JSONArray loadKairos() {
		String response = equivalenciaProductosRepository.loadKairos();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("productos");
	}

	@Override
	public JSONArray loadLolfar() {
		String response = equivalenciaProductosRepository.loadLolfar();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("productos");
	}

	@Override
	public JSONArray loadPrecios() {
		String response = equivalenciaProductosRepository.loadPrecios();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("productos");
	}

}
