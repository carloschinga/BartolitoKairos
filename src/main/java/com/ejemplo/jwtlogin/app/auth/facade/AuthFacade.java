package com.ejemplo.jwtlogin.app.auth.facade;

import com.ejemplo.jwtlogin.dto.model.auth.AutorizacionResponse;
import com.ejemplo.jwtlogin.dto.model.auth.LoginRequest;
import com.ejemplo.jwtlogin.dto.model.auth.TokenRequest;

public interface AuthFacade {
	AutorizacionResponse login(LoginRequest request);

	AutorizacionResponse loginBartolito(LoginRequest request);

	AutorizacionResponse loginInventario(LoginRequest request);

	AutorizacionResponse loginByUsername(LoginRequest request);

	AutorizacionResponse loginBartolitoByUsername(LoginRequest request);

	AutorizacionResponse loginInventarioByUsername(LoginRequest request);
	
	AutorizacionResponse getUser(TokenRequest request);

	AutorizacionResponse getUserFromTokenBartolito(TokenRequest request); 
	
	AutorizacionResponse getUserFromTokenInventario(TokenRequest request);

	AutorizacionResponse refreshToken(String refreshToken);
}
