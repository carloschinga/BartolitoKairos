package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicoResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 4484112760440285742L;

	private String dniMedico;
	private String medico;

}
