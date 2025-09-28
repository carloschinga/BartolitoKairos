package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosDrogasFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosDrogasService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosDrogasFacadeImpl extends FacadeBase implements KairosDrogasFacade {

	@Autowired
	private KairosDrogasService drogaService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		drogaService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	}

	@Override
	public BaseOperacionResponse saveOrUpdateDrogaProductoFile(MultipartFile file) {
		drogaService.saveOrUpdateDrogaProductoFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	}

}
