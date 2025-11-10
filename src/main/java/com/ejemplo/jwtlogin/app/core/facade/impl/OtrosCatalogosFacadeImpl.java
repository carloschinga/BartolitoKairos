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
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosFileRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosResponse;

@Component
public class OtrosCatalogosFacadeImpl extends FacadeBase implements OtrosCatalogosFacade {

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

		for (int i = 0; i < listDTO.length(); i++) {
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

		for (int i = 0; i < listDTO.length(); i++) {
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

	@Override
	public BaseOperacionResponse save(ProductoOtrosCatalogosFileRequest t) {
		try {
	        String result = otrosCatalogosService.save(t);
	        
	        switch (result) {
	            case "OK":
	                return new BaseOperacionResponse(Constantes.SUCCESS, "Producto registrado exitosamente.");
	            case "DUPLICADO":
	                return new BaseOperacionResponse(Constantes.ERROR, "El producto ya existe en este catálogo.");
	            case "ERROR_DB":
	                return new BaseOperacionResponse(Constantes.ERROR, "Error en la base de datos.");
	            default:
	                return new BaseOperacionResponse(Constantes.ERROR, "Error al registrar el producto.");
	        }
	    } catch (Exception e) {
	        System.err.println("Error en facade: " + e.getMessage());
	        return new BaseOperacionResponse(Constantes.ERROR, "Error interno del sistema.");
	    }
	}

	@Override
	public BaseOperacionResponse update(ProductoOtrosCatalogosFileRequest t) {
		otrosCatalogosService.update(t);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Producto actualizado exitosamente.");
	}

	@Override
	public BaseOperacionResponse delete(ProductoOtrosCatalogosFileRequest t) {
		otrosCatalogosService.delete(t);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Producto eliminado exitosamente.");
	}

}
