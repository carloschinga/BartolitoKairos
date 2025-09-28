package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosProductosFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosProductosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosProductosFacadeImpl extends FacadeBase implements KairosProductosFacade {

	@Autowired
	private KairosProductosService kairosProductosService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosProductosService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	} 
	
	
	
}
