package com.ejemplo.jwtlogin.app.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosPreciosFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/precios")
public class KairosPreciosRestController {

	@Autowired
	private KairosPreciosFacade kairosPreciosFacade;
	
	@PostMapping("/saveOrUpdateFile")
	public BaseOperacionResponse saveOrUpdateFile(@RequestBody MultipartFile file) {
		return kairosPreciosFacade.saveOrUpdateFile(file);
	}

}
