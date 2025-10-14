package com.ejemplo.jwtlogin.app.core.facade;

import java.util.List;
import java.util.UUID;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoKairosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoLolfarResponse;

public interface EquivalenciaProductosFacade {

	BaseOperacionResponse save(EquivalenciaProductosRequest request);

	BaseOperacionResponse delete(UUID equivalenciaProductosId);

	List<EquivalenciaProductosResponse> load();

	List<ProductoKairosResponse> loadKairos();

	List<ProductoLolfarResponse> loadLolfar();
}
