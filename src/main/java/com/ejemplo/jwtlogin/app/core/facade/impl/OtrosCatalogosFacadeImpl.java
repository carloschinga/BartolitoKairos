package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.core.facade.OtrosCatalogosFacade;
import com.ejemplo.jwtlogin.app.core.service.OtrosCatalogosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.ComboTipoCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosResponse;

@Component
public class OtrosCatalogosFacadeImpl  extends FacadeBase implements OtrosCatalogosFacade {

	@Autowired
	private OtrosCatalogosService otrosCatalogosService;
	
	@Override
	public BaseOperacionResponse saveOrUpdateFile(ProductoOtrosCatalogosRequest t) {
		otrosCatalogosService.saveOrUpdate(t);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Archivo otros catalogos cargado exitosamente."); 
	}

	@Override
	public List<ProductoOtrosCatalogosResponse> load(TiposCatalogosRequest t) {
		List<ProductoOtrosCatalogosResponse> collection = new ArrayList<>(); 

		JSONArray listDTO = otrosCatalogosService.load(t); 
		
		for(int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i); 
			ProductoOtrosCatalogosResponse response = new ProductoOtrosCatalogosResponse(); 
			response.setCodpro(producto.getString("codpro"));
			response.setProducto(producto.getString("producto"));
			response.setStkfra(producto.getInt("stkfra"));
			response.setLaboratorio(producto.getString("laboratorio"));
			response.setDci(producto.getString("dci"));
			response.setPrecio(producto.getDouble("precio"));
			response.setCodtip(producto.getInt("codtip"));
			collection.add(response); 
		}
		
		return collection; 
	}

	@Override
	public ComboTipoCatalogosResponse initComboTiposCatalogos() {
		
		List<TiposCatalogosResponse> collection = new ArrayList<>();
		ComboTipoCatalogosResponse combo = new ComboTipoCatalogosResponse(); 
		
		JSONArray listDTO = otrosCatalogosService.initComboCatalogos();
		
		for(int i = 0; i < listDTO.length(); i++) {
			JSONObject tipos = listDTO.getJSONObject(i); 
			TiposCatalogosResponse response = new TiposCatalogosResponse(); 
			response.setCodtip(tipos.getInt("codtip"));
			response.setNombtip(tipos.getString("nombtip"));
			response.setClstipo(tipos.getString("clstipo"));
			collection.add(response); 
		}
		
		combo.setCatalogos(collection);
	
		return combo; 
			
	}

}
