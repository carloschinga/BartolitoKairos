package com.ejemplo.jwtlogin.app.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.core.facade.TiposCatalogosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.tiposCatalogos.TipoCatalogosRequest;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/tiposCatalogos")
public class TiposCatalogosRestController {

	@Autowired
	private TiposCatalogosFacade tiposCatalogosFacade;

	@GetMapping("/get/{codtip}")
	public TiposCatalogosResponse get(@PathVariable Integer codtip) {
		return tiposCatalogosFacade.get(codtip);
	}

	@GetMapping("/load")
	public List<TiposCatalogosResponse> load() {
		return tiposCatalogosFacade.load();
	}

	@PostMapping("/saveOrUpdate")
	public BaseOperacionResponse saveOrUpdate(@RequestBody TipoCatalogosRequest request) {
		return tiposCatalogosFacade.saveOrUpdate(request);
	}

	@DeleteMapping("/delete/{codtip}")
	public BaseOperacionResponse delete(@PathVariable Integer codtip) {
		return tiposCatalogosFacade.delete(codtip);
	}

}
