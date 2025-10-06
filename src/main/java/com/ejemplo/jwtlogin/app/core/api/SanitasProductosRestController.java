package com.ejemplo.jwtlogin.app.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.SanitasProductosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoSanitasResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/sanitas/productos")
public class SanitasProductosRestController {

	@Autowired
	private SanitasProductosFacade sanitasProductosFacade;

	@PostMapping("/saveOrUpdateFile")
	public BaseOperacionResponse saveOrUpdateFile(@RequestBody MultipartFile file) {
		return sanitasProductosFacade.saveOrUpdateFile(file);
	}

	@GetMapping("/load")
	public List<ProductoSanitasResponse> load() {
		return sanitasProductosFacade.load();
	}

}
