package com.ejemplo.jwtlogin.app.core.facade;

import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

public interface KairosDrogasFacade {

	BaseOperacionResponse saveOrUpdateFile(MultipartFile file);
	BaseOperacionResponse saveOrUpdateDrogaProductoFile(MultipartFile file);
	
}
