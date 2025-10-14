package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenericoPreescritoComboRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 7431130283388308810L;
	
	private String medico; 
	private String servicio; 

}
