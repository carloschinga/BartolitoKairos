package com.ejemplo.jwtlogin.dto.model.otrosCatalogos;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComboTipoCatalogosResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6863804748784710515L;

	private List<TiposCatalogosResponse> catalogos; 
	
}
