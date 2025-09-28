package com.ejemplo.jwtlogin.app.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface KairosDrogasService {
	void saveOrUpdateFile(MultipartFile file);
	void saveOrUpdateDrogaProductoFile(MultipartFile file);
}
