package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class GenericoPreescritoRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 66211232681900643L;

	private LocalDate desde; 
	private LocalDate hasta; 
	private String geneId; 
	
}
