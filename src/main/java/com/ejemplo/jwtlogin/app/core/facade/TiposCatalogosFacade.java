package com.ejemplo.jwtlogin.app.core.facade;

import java.util.List;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

public interface TiposCatalogosFacade {
	
	TiposCatalogosResponse get(Integer codtip);
	List<TiposCatalogosResponse> load();
	BaseOperacionResponse saveOrUpdate(TipoCatalogosRequest request);
	BaseOperacionResponse delete(Integer codtip);
}
