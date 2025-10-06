package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoSanitasResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1733282434011655860L;
	
	private String codpro;
	private String producto;
	private Integer stkfra;
	private String laboratorio;
	private String dci;
	private Double precio;
}
