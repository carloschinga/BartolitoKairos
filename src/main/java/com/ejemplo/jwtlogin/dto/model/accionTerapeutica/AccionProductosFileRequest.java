package com.ejemplo.jwtlogin.dto.model.accionTerapeutica;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccionProductosFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 934909430325984030L;
	private String accionTerapeuticasId;
	private String productosId;
	private String especificacionPresentacion;
	private String viaAdministracion;
	private String medioPresentacion;
	private String importanciaAsociacion;

}
