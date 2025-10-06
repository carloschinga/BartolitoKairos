package com.ejemplo.jwtlogin.app.core.facade;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.dto.model.BaseOperacionResponse;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoSanitasResponse;

public interface SanitasProductosFacade {
	BaseOperacionResponse saveOrUpdateFile(MultipartFile file);

	List<ProductoSanitasResponse> load();
}
