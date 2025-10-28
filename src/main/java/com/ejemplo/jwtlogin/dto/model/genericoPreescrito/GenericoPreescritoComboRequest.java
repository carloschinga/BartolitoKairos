package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.util.List;

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
	
    private List<String> medico; 
    private List<String> servicio; 
    private List<String> diades;

}
