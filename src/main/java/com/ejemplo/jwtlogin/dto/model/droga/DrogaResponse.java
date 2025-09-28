package com.ejemplo.jwtlogin.dto.model.droga;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DrogaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4538254655281746955L;

	private UUID kairosDrogasId; 
	private String drogasId; 
	private String descripcion; 
	private String estado; 
	
}
