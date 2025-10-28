package com.ejemplo.jwtlogin.app.core.service;

import org.json.JSONArray;

import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

public interface TiposCatalogosService {
	
	JSONArray load();
	JSONArray getById(Integer codtip);
	void saveOrUpdate(TipoCatalogosRequest request);
	String delete(Integer codtip);

}
