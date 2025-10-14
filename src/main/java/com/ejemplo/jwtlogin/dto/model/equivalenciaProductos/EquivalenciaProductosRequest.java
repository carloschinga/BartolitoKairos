package com.ejemplo.jwtlogin.dto.model.equivalenciaProductos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquivalenciaProductosRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 4242475186802446684L;

	private String codpro;
	private String productosId;
	private String presentacionesId;

}
