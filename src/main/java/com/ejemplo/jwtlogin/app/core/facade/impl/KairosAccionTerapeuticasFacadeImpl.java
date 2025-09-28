package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosAccionTerapeuticasFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosAccionTerapeuticasService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosAccionTerapeuticasFacadeImpl extends FacadeBase implements KairosAccionTerapeuticasFacade {

	@Autowired
	private KairosAccionTerapeuticasService kairosAccionTerapeuticasService; 
	
	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosAccionTerapeuticasService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	}

	@Override
	public BaseOperacionResponse saveOrUpdateAccionProductoFile(MultipartFile file) {
		kairosAccionTerapeuticasService.saveOrUpdateAccionProductoFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	}

}
