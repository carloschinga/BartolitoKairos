package com.ejemplo.jwtlogin.app.core.facade;

import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;

public interface KairosProductosFacade {
	BaseOperacionResponse saveOrUpdateFile(MultipartFile file);
}
