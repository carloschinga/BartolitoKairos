package com.ejemplo.jwtlogin.app.core.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.core.facade.EquivalenciaProductosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosRequest;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.EquivalenciaProductosResponse;
import com.ejemplo.jwtlogin.dto.model.equivalenciaProductos.ProductoPreciosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoKairosResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoLolfarResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/equivalenciaProductos")
public class EquivalenciaProductosRestController {

	@Autowired
	private EquivalenciaProductosFacade equivalenciaProductosFacade;

	@PostMapping("/save")
	public BaseOperacionResponse save(@RequestBody EquivalenciaProductosRequest request) {
		return equivalenciaProductosFacade.save(request);
	}

	@DeleteMapping("/delete/{equivalenciaProductosId}")
	public BaseOperacionResponse delete(@PathVariable UUID equivalenciaProductosId) {
		return equivalenciaProductosFacade.delete(equivalenciaProductosId);
	}

    @DeleteMapping("/deleteproducto/{codpro}")
    public BaseOperacionResponse delete(@PathVariable String codpro) {
        return equivalenciaProductosFacade.deleteproducto(codpro);
    }

	@GetMapping("/load")
	public List<EquivalenciaProductosResponse> load() {
		return equivalenciaProductosFacade.load();
	}

	@GetMapping("/loadKairos")
	public List<ProductoKairosResponse> loadKairos() {
		return equivalenciaProductosFacade.loadKairos();
	}

	@GetMapping("/loadLolfar")
	public List<ProductoLolfarResponse> loadLolfar() {
		return equivalenciaProductosFacade.loadLolfar();
	}
	
	@GetMapping("/loadPrecios")
	public List<ProductoPreciosResponse> loadPrecios(){
		return equivalenciaProductosFacade.loadPrecios();
	}
	
}
