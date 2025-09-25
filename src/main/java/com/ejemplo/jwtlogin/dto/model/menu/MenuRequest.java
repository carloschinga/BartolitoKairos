package com.ejemplo.jwtlogin.dto.model.menu;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6319536804001904327L;
	
	private String tipo;

}
