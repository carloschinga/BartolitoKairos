package com.ejemplo.jwtlogin.app.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface KairosLaboratoriosService {
	void saveOrUpdateFile(MultipartFile file);
}
