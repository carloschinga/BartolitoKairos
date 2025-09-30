package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoFiltroRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8904121952759900163L;
	
	private String laboratorio; 

}
