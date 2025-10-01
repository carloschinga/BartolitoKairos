package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosPreciosFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosPreciosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosPreciosFacadeImpl extends FacadeBase implements KairosPreciosFacade {

	@Autowired
	private KairosPreciosService kairosPreciosService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosPreciosService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Guardado precios exitosamente.");
	} 
	
}
