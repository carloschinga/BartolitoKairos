package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.SanitasProductosFacade;
import com.ejemplo.jwtlogin.app.core.service.SanitasProductosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoSanitasResponse;

@Component
public class SanitasProductosFacadeImpl  extends FacadeBase implements SanitasProductosFacade {

	@Autowired
	private SanitasProductosService sanitasProductosService; 
	
	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		sanitasProductosService.saveOrUpdate(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Archivo sanitas cargado exitosamente."); 
	}

	@Override
	public List<ProductoSanitasResponse> load() {
		List<ProductoSanitasResponse> collection = new ArrayList<>(); 

		JSONArray listDTO = sanitasProductosService.load(); 
		
		for(int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i); 
			ProductoSanitasResponse response = new ProductoSanitasResponse(); 
			response.setCodpro(producto.getString("codpro"));
			response.setProducto(producto.getString("producto"));
			response.setStkfra(producto.getInt("stkfra"));
			response.setLaboratorio(producto.getString("laboratorio"));
			response.setDci(producto.getString("dci"));
			response.setPrecio(producto.getDouble("precio"));
			collection.add(response); 
		}
		
		return collection; 
	}

}
