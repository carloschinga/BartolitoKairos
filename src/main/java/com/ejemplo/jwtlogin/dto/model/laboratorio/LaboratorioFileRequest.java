package com.ejemplo.jwtlogin.dto.model.laboratorio;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LaboratorioFileRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5142847780993962308L;

	private UUID kairosDrogasId;
	private String laboratoriosId;
	private String descripcion;
	private String estado;
	private MultipartFile file;
	
}
