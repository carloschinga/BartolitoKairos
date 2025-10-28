package com.ejemplo.jwtlogin.app.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.core.facade.OtrosCatalogosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.ComboTipoCatalogosResponse;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/otros/productos")
public class OtrosCatalogosRestController {

	@Autowired
	private OtrosCatalogosFacade otrosCatalogosFacade;

	@PostMapping("/saveOrUpdateFile")
	public BaseOperacionResponse saveOrUpdateFile(@ModelAttribute ProductoOtrosCatalogosRequest request) {
		return otrosCatalogosFacade.saveOrUpdateFile(request);
	}

	@PostMapping("/load")
	public List<ProductoOtrosCatalogosResponse> load(@RequestBody TiposCatalogosRequest request) {
		return otrosCatalogosFacade.load(request);
	}

	@GetMapping("/initComboTiposCatalogos")
	public ComboTipoCatalogosResponse initComboTiposCatalogos() {
		return otrosCatalogosFacade.initComboTiposCatalogos();
	}	

}
