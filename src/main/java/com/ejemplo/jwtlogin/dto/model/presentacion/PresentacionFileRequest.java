package com.ejemplo.jwtlogin.dto.model.presentacion;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PresentacionFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2193178593077693395L;
	private String presentacionesId;
	private String productosId;
	private String descripcion;
	private String estado;
}
