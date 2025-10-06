package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoSanitasFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -5654083030948986803L;

	private String codpro; 
	private String prod; 
	private Integer stk; 
	private String lab; 
	private String dci; 
	private Double prec; 
	
}
