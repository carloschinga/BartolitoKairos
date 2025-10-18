package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.core.facade.EquivalenciaProductosFacade;
import com.ejemplo.jwtlogin.app.core.service.EquivalenciaProductosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoKairosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoLolfarResponse;

@Component
public class EquivalenciaProductosFacadeImpl extends FacadeBase implements EquivalenciaProductosFacade {

	@Autowired
	private EquivalenciaProductosService equivalenciaProductosService;

	@Override
	public BaseOperacionResponse save(EquivalenciaProductosRequest t) {
		equivalenciaProductosService.save(t);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Equivalencia guardada exitosamente.");
	}

    @Override
    public BaseOperacionResponse deleteproducto(String codpro) {
        equivalenciaProductosService.deleteproducto(codpro);
        return new BaseOperacionResponse(Constantes.SUCCESS, "Producto eliminado de equivalencia " + codpro+" equivalencia eliminada exitosamente.");
    }

	@Override
	public BaseOperacionResponse delete(UUID equivalenciaProductosId) {
		equivalenciaProductosService.delete(equivalenciaProductosId);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Equivalencia eliminada exitosamente.");
	}

	@Override
	public List<EquivalenciaProductosResponse> load() {
		List<EquivalenciaProductosResponse> collection = new ArrayList<>();

		JSONArray listDTO = equivalenciaProductosService.load();

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i);
			EquivalenciaProductosResponse response = new EquivalenciaProductosResponse();
			response.setEquivalenciaProductosId(UUID.fromString(producto.getString("equivalencia_productos_id")));
			response.setCodpro(producto.getString("codpro"));
			response.setDespro(producto.getString("despro"));
			response.setCodlab(producto.getString("codlab"));
			response.setDeslab(producto.getString("deslab"));
			response.setProductosId(producto.getString("productos_id"));
			response.setKairosProducto(producto.getString("kairos_producto"));
			response.setEstaequi(producto.getString("estaequi"));
			response.setPresentacionesId(producto.getString("presentaciones_id"));

			response.setKairosId(response.getProductosId() + "-" + response.getPresentacionesId());

			collection.add(response);
		}

		return collection;
	}

	@Override
	public List<ProductoKairosResponse> loadKairos() {
		List<ProductoKairosResponse> collection = new ArrayList<>();

		JSONArray listDTO = equivalenciaProductosService.loadKairos();

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i);
			ProductoKairosResponse response = new ProductoKairosResponse();
			response.setProductosId(producto.getString("productos_id"));
			response.setDescripcion(producto.getString("producto"));
			response.setLaboratoriosId(producto.getString("laboratorios_id"));
			response.setLaboratorio(producto.getString("laboratorio"));
			response.setPresentacionesId(producto.getString("presentaciones_id"));

			if (producto.has("genericos") && !producto.isNull("genericos")) {
			    response.setGenericos(producto.getString("genericos").toUpperCase());
			} else {
			    response.setGenericos("-");
			}

			if (producto.getString("estado").equals("B")) {
				//response.setEstado("INACTIVO");
                response.setEstado("D");
			} else {
                response.setEstado("A");
				//response.setEstado(producto.getString("estado"));
			}
            response.setBart_kairos_productos_id(producto.getString("bart_kairos_productos_id"));

			response.setKairosId(response.getProductosId() + "-" + response.getPresentacionesId());

			collection.add(response);
		}

		return collection;
	}

	@Override
	public List<ProductoLolfarResponse> loadLolfar() {
		List<ProductoLolfarResponse> collection = new ArrayList<>();

		JSONArray listDTO = equivalenciaProductosService.loadLolfar();

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject producto = listDTO.getJSONObject(i);
			ProductoLolfarResponse response = new ProductoLolfarResponse();
			response.setCodpro(producto.getString("codpro"));
			response.setDespro(producto.getString("despro"));
			response.setCodlab(producto.getString("codlab"));
			response.setDeslab(producto.getString("deslab"));
			response.setCodtip(producto.getString("codtip"));
			response.setDestip(producto.getString("destip"));
			response.setCodgen(producto.getString("codgen"));
			response.setDesgen(producto.getString("desgen"));
			response.setEstado(producto.getString("estado"));

			collection.add(response);
		}

		return collection;
	}

}
