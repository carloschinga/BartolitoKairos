package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.core.facade.TiposCatalogosFacade;
import com.ejemplo.jwtlogin.app.core.service.TiposCatalogosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

@Component
public class TiposCatalogosFacadeImpl extends FacadeBase implements TiposCatalogosFacade {

	@Autowired
	private TiposCatalogosService tiposCatalogosService;

	@Override
	public TiposCatalogosResponse get(Integer codtip) {
		TiposCatalogosResponse response = new TiposCatalogosResponse();

		JSONArray listDTO = tiposCatalogosService.getById(codtip);

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject catalogo = listDTO.getJSONObject(i);
			response.setCodtip(catalogo.getInt("codtip"));
			response.setNombtip(catalogo.getString("nombtip"));
			response.setClstipo(catalogo.getString("clstipo"));
		}

		return response;

	}

	@Override
	public List<TiposCatalogosResponse> load() {
		List<TiposCatalogosResponse> collection = new ArrayList<>();

		JSONArray listDTO = tiposCatalogosService.load();

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject catalogo = listDTO.getJSONObject(i);
			TiposCatalogosResponse response = new TiposCatalogosResponse();
			response.setCodtip(catalogo.getInt("codtip"));
			response.setNombtip(catalogo.getString("nombtip"));
			response.setClstipo(catalogo.getString("clstipo"));
			collection.add(response);
		}

		return collection;
	}

	@Override
	public BaseOperacionResponse saveOrUpdate(TipoCatalogosRequest t) {
		tiposCatalogosService.saveOrUpdate(t);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Tipo de catalogo guardado exitosamente.");
	}

	@Override
	public BaseOperacionResponse delete(Integer codtip) {
		String result = tiposCatalogosService.delete(codtip);
		if (result.contains("\"error\"")) {
			String mensaje = result.replace("{\"error\":\"", "").replace("\"}", "");
			return new BaseOperacionResponse(Constantes.ERROR, mensaje);
		}
		return new BaseOperacionResponse(Constantes.SUCCESS, "Tipo de catálogo eliminado exitosamente.");
	}

}
