package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenericoPreescritoResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8821861249081486007L;

	private String geneId;
	private String geneDesc;
	private String geneEst;
	private List<ProductoResponse> productos;

}
