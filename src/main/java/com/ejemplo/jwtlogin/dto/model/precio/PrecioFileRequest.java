package com.ejemplo.jwtlogin.dto.model.precio;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrecioFileRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -2852548893051396796L;

	private String productosId;
	private String presentacionesId;
	private Double precioFabrica;
	private Double precioPublico;
	private LocalDate fechaVigencia;

}
