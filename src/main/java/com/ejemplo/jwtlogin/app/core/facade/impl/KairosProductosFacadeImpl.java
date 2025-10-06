package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosProductosFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosProductosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoResponse;

@Component
public class KairosProductosFacadeImpl extends FacadeBase implements KairosProductosFacade {

	@Autowired
	private KairosProductosService kairosProductosService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosProductosService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Guardados productos exitosamente.");
	}

	@Override
	public List<ProductoResponse> load() {
		List<ProductoResponse> collection = new ArrayList<>(); 

		JSONArray listDTO = kairosProductosService.load(); 
		
		for(int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i); 
			ProductoResponse response = new ProductoResponse(); 
			response.setProductosId(producto.getString("productos_id"));
			response.setProducto(producto.getString("producto"));
			response.setLaboratorio(producto.getString("laboratorio"));
			response.setPrecioFabrica(producto.getDouble("precio_fabrica"));
			response.setPrecioPublico(producto.getDouble("precio_publico"));
			response.setFechaVigencia(producto.getString("fecha_vigencia"));
			collection.add(response); 
		}
		
		return collection; 
		
	} 
	
	
	
}
