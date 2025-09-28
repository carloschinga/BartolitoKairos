package com.ejemplo.jwtlogin.dto.model.droga;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrogaFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4726871176943920596L;

	private UUID kairosDrogasId;
	private String drogasId;
	private String descripcion;
	private String estado;
	private MultipartFile file;

}
