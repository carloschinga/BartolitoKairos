package com.ejemplo.jwtlogin.app.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface KairosAccionTerapeuticasService {
	
	void saveOrUpdateFile(MultipartFile file);
	void saveOrUpdateAccionProductoFile(MultipartFile file);

}
