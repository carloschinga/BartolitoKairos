package com.ejemplo.jwtlogin.dto.model.equivalenciaProductos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoPreciosResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1690438528180096302L;

	private String codpro; 
	private String producto; 
	private String laboratorio; 
	private String dci; 
	private Double pvf; 
	private Double pps; 
	private Integer codtip; 
	private String nombtip; 
}
