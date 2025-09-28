package com.ejemplo.jwtlogin.dto.model.producto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoFileRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3444121646442080522L;
	private String productosId; 
	private String laboratoriosId; 
	private String descripcion; 
	private String psicofarmaco; 
	private String codigoVenta; 
	private String estupefaciente; 
	private String estado; 
}
