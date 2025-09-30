package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -981522463752919669L;
	
	private UUID bartKairosProductosId; 
	private String productosId;
	private String producto; 
	private String laboratorio;
	private Double precioFabrica; 
	private Double precioPublico; 
	private String fechaVigencia; 
	
}
