package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiadesResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2988931854431331099L;

	private String diades;
	private String servicio;
	private String medico;
}
