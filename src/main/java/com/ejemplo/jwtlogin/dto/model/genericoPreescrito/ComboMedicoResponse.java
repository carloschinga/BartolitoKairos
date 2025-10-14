package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComboMedicoResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -443583660325523704L;

	private List<MedicoResponse> medicos;

}
