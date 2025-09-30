package com.ejemplo.jwtlogin.app.core.service;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface KairosProductosService {
	void saveOrUpdateFile(MultipartFile file);
	JSONArray load();
}
