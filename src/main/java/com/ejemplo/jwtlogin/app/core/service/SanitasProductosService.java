package com.ejemplo.jwtlogin.app.core.service;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface SanitasProductosService {
	void saveOrUpdate(MultipartFile file);

	JSONArray load();
}
