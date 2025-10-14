package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoKairosResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3067125396916294452L;

	private String productosId;
	private String descripcion;
	private String laboratoriosId;
	private String laboratorio;
	private String presentacionesId;

}
