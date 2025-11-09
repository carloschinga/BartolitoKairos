package com.ejemplo.jwtlogin.dto.model.equivalenciaProductos;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquivalenciaProductosResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 3341714187977058087L;

	/*private UUID equivalenciaProductosId;
	private String codpro;
	private String despro;
	private String codlab;
	private String deslab;
	private String productosId;
	private String kairosId;
	private String kairosProducto;
	private String estaequi;
	private String presentacionesId;*/

    private UUID equivalenciaProductosId;
    private String codpro;
    private String despro;
    private String deslab;
    private String desgen;
    private String productosId;
    private String presentacionesId;
    private String kairosProducto;
    private String kairosLaboratorio;
    private String kairosGenerico;
    private String estaequi;

}
