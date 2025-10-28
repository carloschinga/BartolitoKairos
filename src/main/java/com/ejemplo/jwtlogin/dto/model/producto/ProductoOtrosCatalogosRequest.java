package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoOtrosCatalogosRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 7989726452698930327L;

	private MultipartFile file;
	private Integer codtip; 
}
