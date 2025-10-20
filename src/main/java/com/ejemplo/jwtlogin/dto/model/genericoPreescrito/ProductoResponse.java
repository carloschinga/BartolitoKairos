package com.ejemplo.jwtlogin.dto.model.genericoPreescrito;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8343002114423395041L;

	private String codproLolfar;
	private String prodId;
	private String producto;
	private String prodEst;
	private String laboId;
	private String laboDesc;
	private String medico;
	private String servicio;
	private String diades;
	private Integer cantidad;
	private String fechaAtencion;

}
