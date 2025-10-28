package com.ejemplo.jwtlogin.dto.model.tiposCatalogos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoCatalogosRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8436390558259614901L;

	private Integer codtip; 
	private String nombtip; 
	
}
