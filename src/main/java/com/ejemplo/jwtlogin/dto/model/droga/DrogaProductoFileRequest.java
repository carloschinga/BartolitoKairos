package com.ejemplo.jwtlogin.dto.model.droga;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrogaProductoFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 4851077001827344858L;

	private String drogasId;
	private String productosId;
	private String especificacionPresentacion;
	private String viaAdministracion;
	private String medioPresentacion;
	private String importanciaAsociacion;

}
