package com.ejemplo.jwtlogin.dto.model.auth;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7223868437269433789L;
	private String token; 

}
