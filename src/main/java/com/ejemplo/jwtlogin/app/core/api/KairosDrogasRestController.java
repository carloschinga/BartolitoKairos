package com.ejemplo.jwtlogin.app.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosDrogasFacade;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/kairos/drogas")
public class KairosDrogasRestController {
	
	@Autowired
	private KairosDrogasFacade drogaFacade; 
	
	@PostMapping("/saveOrUpdateFile")
	public BaseOperacionResponse saveOrUpdateFile(@RequestBody MultipartFile file ) {
		return drogaFacade.saveOrUpdateFile(file);
	}
	
	@PostMapping("/saveOrUpdateDrogaProductoFile")
	public BaseOperacionResponse saveOrUpdateDrogaProductoFile(@RequestBody MultipartFile file ) {
		return drogaFacade.saveOrUpdateDrogaProductoFile(file);
	}
	

}
