package com.ejemplo.jwtlogin.dto.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SesionResponse  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4657147503575271756L;
	private String useusr;
	private Integer usecod;
	private String grucod;
}
