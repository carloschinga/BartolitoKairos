package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComboDiadesServicioMedicoResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -8221473247821869367L;

	private List<DiadesResponse> diades; 
	
}
