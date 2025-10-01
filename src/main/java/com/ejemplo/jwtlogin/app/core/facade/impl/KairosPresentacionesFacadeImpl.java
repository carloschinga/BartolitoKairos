package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosPresentacionesFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosPresentacionesService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosPresentacionesFacadeImpl extends FacadeBase implements KairosPresentacionesFacade {

	@Autowired
	private KairosPresentacionesService kairosPresentacionesService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosPresentacionesService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "Guardado presentaciones exitosamente.");
	} 
	
}
