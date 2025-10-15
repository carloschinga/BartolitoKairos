package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoLolfarResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4554511654134821801L;

	private String codpro;
	private String despro;
	private String codlab;
	private String deslab;
	private String codtip;
	private String destip;
	private String codgen;
	private String desgen;
	private String estado;

}
