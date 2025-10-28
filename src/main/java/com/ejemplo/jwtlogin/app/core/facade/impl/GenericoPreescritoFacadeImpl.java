package com.ejemplo.jwtlogin.app.core.facade.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.core.facade.GenericoPreescritoFacade;
import com.ejemplo.jwtlogin.app.core.service.GenericoPreescritoService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboDiadesServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.DiadesResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.MedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ProductoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ServicioResponse;

@Component
public class GenericoPreescritoFacadeImpl extends FacadeBase implements GenericoPreescritoFacade {

	@Autowired
	private GenericoPreescritoService genericoPreescritoService;

	@Override
	public List<GenericoPreescritoResponse> load(GenericoPreescritoRequest t) {
		JSONArray listDTO = genericoPreescritoService.load(t); // trae filas de productos

		Map<String, GenericoPreescritoResponse> mapaGenericos = new LinkedHashMap<>();

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject fila = listDTO.getJSONObject(i);
			String geneId = fila.getString("GeneId");
			String prodId = fila.getString("ProdId");

			// Obtiene o crea el genérico
			GenericoPreescritoResponse generico = mapaGenericos.getOrDefault(geneId, new GenericoPreescritoResponse());
			generico.setGeneId(fila.getString("GeneId"));

			if (geneId.isEmpty()) {
				generico.setGeneDesc("NO ESPECIFICADO");
			} else {
				generico.setGeneDesc(fila.optString("GeneDesc", ""));
			}

			generico.setGeneEst(fila.getString("GeneEst"));

			if (generico.getProductos() == null)
				generico.setProductos(new ArrayList<>());

			// Verifica si el producto ya está agregado
			boolean existe = generico.getProductos().stream().anyMatch(p -> p.getProdId().equals(prodId));
			if (!existe) {
				ProductoResponse producto = new ProductoResponse();
				producto.setProdId(fila.optString("ProdId", ""));
				producto.setProducto(fila.optString("Producto", ""));
				producto.setCodproLolfar(fila.optString("CodproLolfar", ""));
				producto.setProdEst(fila.optString("ProdEst", ""));
				producto.setLaboId(fila.optString("LaboId", ""));
				producto.setLaboDesc(fila.optString("LaboDesc", ""));
				producto.setCantidad(fila.optInt("Cantidad", 0));
				producto.setFechaAtencion(fila.optString("FechaAtencion", ""));
				producto.setDiades(fila.optString("Diades", ""));
				producto.setServicio(fila.optString("Servicio", ""));
				producto.setMedico(fila.optString("Medico", ""));
				generico.getProductos().add(producto);
			}

			mapaGenericos.put(geneId, generico);
		}

		return new ArrayList<>(mapaGenericos.values());
	}

	@Override
	public ComboMedicoResponse initComboMedico(GenericoPreescritoComboRequest t) {
		ComboMedicoResponse combo = new ComboMedicoResponse();

		List<MedicoResponse> medicos = new ArrayList<>();

		JSONArray listDTO = genericoPreescritoService.initComboMedico(t);

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject medico = listDTO.getJSONObject(i);
			MedicoResponse response = new MedicoResponse();

			response.setDniMedico(medico.getString("DniMedico"));
			response.setMedico(medico.getString("Medico"));

			medicos.add(response);
		}

		combo.setMedicos(medicos);

		return combo;
	}

	@Override
	public ComboServicioMedicoResponse initComboServicio(GenericoPreescritoComboRequest t) {
		ComboServicioMedicoResponse combo = new ComboServicioMedicoResponse();

		List<ServicioResponse> servicios = new ArrayList<>();

		JSONArray listDTO = genericoPreescritoService.initComboServicioMedico(t);

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject servicio = listDTO.getJSONObject(i);
			
			String nombre = servicio.optString("Servicio", null);

			if (nombre != null && !nombre.trim().isEmpty()) {
				ServicioResponse response = new ServicioResponse();
				response.setServicio(nombre);
				servicios.add(response);
			}
		}

		combo.setServicios(servicios);

		return combo;
	}

	@Override
	public ComboDiadesServicioMedicoResponse initComboDiades(GenericoPreescritoComboRequest t) {
		ComboDiadesServicioMedicoResponse combo = new ComboDiadesServicioMedicoResponse();

		List<DiadesResponse> diades = new ArrayList<>();

		JSONArray listDTO = genericoPreescritoService.initComboDiadesServicioMedico(t);

		for (int i = 0; i < listDTO.length(); i++) {
			JSONObject diade = listDTO.getJSONObject(i);

			String nombreDiades = diade.optString("Diades", null);
			String servicio = diade.optString("Servicio", null);
			String medico = diade.optString("Medico", null);

			nombreDiades = (nombreDiades != null) ? nombreDiades.trim() : null;
			servicio = (servicio != null) ? servicio.trim() : null;
			medico = (medico != null) ? medico.trim() : null;

			if (nombreDiades != null && !nombreDiades.isEmpty()) {
				DiadesResponse response = new DiadesResponse();
				response.setDiades(nombreDiades);
				response.setServicio(servicio);
				response.setMedico(medico);
				diades.add(response);
			}
		}

		combo.setDiades(diades);

		return combo;
	}

}
