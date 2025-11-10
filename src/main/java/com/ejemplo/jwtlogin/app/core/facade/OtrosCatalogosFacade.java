package com.ejemplo.jwtlogin.app.core.facade;

import java.util.List;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.ComboTipoCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosFileRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosResponse;

public interface OtrosCatalogosFacade {
	BaseOperacionResponse saveOrUpdateFile(ProductoOtrosCatalogosRequest request);

	List<ProductoOtrosCatalogosResponse> load(TiposCatalogosRequest request);

	ComboTipoCatalogosResponse initComboTiposCatalogos();

	BaseOperacionResponse save(ProductoOtrosCatalogosFileRequest t);

	BaseOperacionResponse update(ProductoOtrosCatalogosFileRequest t);

	BaseOperacionResponse delete(ProductoOtrosCatalogosFileRequest t);
}
