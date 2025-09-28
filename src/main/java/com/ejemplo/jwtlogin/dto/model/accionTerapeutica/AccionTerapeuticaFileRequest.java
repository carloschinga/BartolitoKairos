package com.ejemplo.jwtlogin.dto.model.accionTerapeutica;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccionTerapeuticaFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 6523164842181715418L;

	private UUID kairosAccionTerapeuticasId;
	private String accionTerapeuticasId;
	private String descripcion;
	private String estado;
	private MultipartFile file;

}
