package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServicioResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 791556361355352706L;

	private String servicio;
}
