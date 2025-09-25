package com.ejemplo.jwtlogin.dto.model.menu;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1597117450059293367L;

	private Integer pagId;
	private String pagNombre;
	private String pagRuta;
	private String tipMenu;
	private Integer pagPadre;
	private Integer iClass;

}
