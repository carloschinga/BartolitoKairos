package com.ejemplo.jwtlogin.app.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface KairosProductosService {
	void saveOrUpdateFile(MultipartFile file);
}
