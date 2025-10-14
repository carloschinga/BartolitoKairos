package com.ejemplo.jwtlogin.app.core.service;

import org.json.JSONArray;

import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;

public interface GenericoPreescritoService {
	
	JSONArray load(GenericoPreescritoRequest request);

	JSONArray loadProductos(GenericoPreescritoRequest request);
	
	JSONArray initComboMedico();

	JSONArray initComboServicioMedico(GenericoPreescritoComboRequest request);
	
	JSONArray initComboDiadesServicioMedico(GenericoPreescritoComboRequest request);
	
}
