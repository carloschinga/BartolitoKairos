package com.ejemplo.jwtlogin.app.core.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.core.repository.TiposCatalogosRepository;
import com.ejemplo.jwtlogin.app.core.service.TiposCatalogosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

@Service
public class TiposCatalogosServiceImpl extends ServiceBase implements TiposCatalogosService {

	@Autowired
	private TiposCatalogosRepository tiposCatalogosRepository;

	@Override
	public JSONArray load() {
		String response = tiposCatalogosRepository.load();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("catalogos");
	}

	@Override
	public JSONArray getById(Integer codtip) {
		String response = tiposCatalogosRepository.getById(codtip);
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("catalogo");
	}

	@Override
	public void saveOrUpdate(TipoCatalogosRequest t) {
		tiposCatalogosRepository.saveOrUpdate(t);
	}

	@Override
	public String delete(Integer codtip) {
		return tiposCatalogosRepository.delete(codtip);
	}
}
