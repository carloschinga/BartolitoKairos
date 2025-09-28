package com.ejemplo.jwtlogin.app.core.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.facade.KairosLaboratoriosFacade;
import com.ejemplo.jwtlogin.app.core.service.KairosLaboratoriosService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.Constantes;
import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

@Component
public class KairosLaboratoriosFacadeImpl extends FacadeBase implements KairosLaboratoriosFacade {

	@Autowired
	private KairosLaboratoriosService kairosLaboratoriosService;

	@Override
	public BaseOperacionResponse saveOrUpdateFile(MultipartFile file) {
		kairosLaboratoriosService.saveOrUpdateFile(file);
		return new BaseOperacionResponse(Constantes.SUCCESS, "guardado");
	}

}
