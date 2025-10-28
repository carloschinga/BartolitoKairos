package com.ejemplo.jwtlogin.dto.model.otrosCatalogos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TiposCatalogosResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3856348268851678056L;

	private Integer codtip;
	private String nombtip;
	private String clstipo;
}
