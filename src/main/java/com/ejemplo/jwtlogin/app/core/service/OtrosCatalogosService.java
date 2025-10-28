package com.ejemplo.jwtlogin.app.core.service;

import org.json.JSONArray;

import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;

public interface OtrosCatalogosService {
	void saveOrUpdate(ProductoOtrosCatalogosRequest request);

	JSONArray load(TiposCatalogosRequest request);
	
	JSONArray initComboCatalogos();
}
