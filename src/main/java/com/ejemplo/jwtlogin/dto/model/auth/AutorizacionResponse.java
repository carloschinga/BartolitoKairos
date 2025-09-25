package com.ejemplo.jwtlogin.dto.model.auth;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AutorizacionResponse  implements Serializable {
 

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6159053067640739047L;
	private String de; 
	private String useusr;
	private Integer usecod;
	private String grucod;
	private String grudes; 
	private String sisent; 
	private Integer siscod; 
	private String codalmInv; 
	private String codalm; 
	private String usenam; 
	private String nombre;
	private String token;
	private String refreshToken; 
}
