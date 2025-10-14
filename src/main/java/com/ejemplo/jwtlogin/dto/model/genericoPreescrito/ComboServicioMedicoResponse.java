package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComboServicioMedicoResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2267503941003747164L;

	private List<ServicioResponse> servicios;

}
