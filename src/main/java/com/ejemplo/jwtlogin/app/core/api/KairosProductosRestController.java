package com.ejemplo.jwtlogin.app.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosProductosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/productos")
public class KairosProductosRestController {

	@Autowired
	private KairosProductosFacade kairosProductosFacade;

	@PostMapping("/saveOrUpdateFile")
	public BaseOperacionResponse saveOrUpdateFile(@RequestBody MultipartFile file) {
		return kairosProductosFacade.saveOrUpdateFile(file);
	}

}
