package com.ejemplo.jwtlogin.app.core.service;

import java.util.UUID;

import org.json.JSONArray;

import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;

public interface EquivalenciaProductosService {

	void save(EquivalenciaProductosRequest request);

	void delete(UUID equivalenciaProductosId);

    void deleteproducto(String codigo);

	JSONArray load();

	JSONArray loadKairos();

	JSONArray loadLolfar();
	
	JSONArray loadPrecios();
}
