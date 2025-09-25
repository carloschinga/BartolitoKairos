package com.ejemplo.jwtlogin.app.auth.facade.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.auth.facade.AuthFacade;
import com.ejemplo.jwtlogin.app.auth.service.AuthService;
import com.ejemplo.jwtlogin.core.exception.UnauthorizedException;
import com.ejemplo.jwtlogin.core.filter.JwtTokenUtil;
import com.ejemplo.jwtlogin.dto.GenericUtil;
import com.ejemplo.jwtlogin.dto.model.auth.AutorizacionResponse;
import com.ejemplo.jwtlogin.dto.model.auth.LoginRequest;
import com.ejemplo.jwtlogin.dto.model.auth.TokenRequest;

@Component
public class AuthFacadeImpl implements AuthFacade {

	@Autowired
	private AuthService authService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public AutorizacionResponse login(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.login(t.getUsername(), t.getPassword());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setUsenam(result.getString("usenam").replace("\"", ""));
		response.setNombre(result.getString("nombre").replace("\"", ""));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse loginBartolito(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.loginBartolito(t.getUsername(), t.getPassword());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setGrudes(result.getString("grudes"));
		response.setCodalm(result.getString("codalm"));
		response.setUsenam(result.getString("usenam"));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse loginInventario(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.loginInventario(t.getUsername(), t.getPassword());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setGrudes(result.getString("grudes"));
		response.setSisent(result.getString("sisent"));
		response.setSiscod(result.getInt("siscod"));
		response.setCodalmInv(result.getString("codalm_inv"));
		response.setUsenam(result.getString("usenam"));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse loginByUsername(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.loginByUser(t.getUsername());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setUsenam(result.getString("usenam").replace("\"", ""));
		response.setNombre(result.getString("nombre").replace("\"", ""));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse loginBartolitoByUsername(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.loginBartolitoByUser(t.getUsername());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setCodalm(result.getString("codalm"));
		response.setUsenam(result.getString("usenam"));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse loginInventarioByUsername(LoginRequest t) {
		if (GenericUtil.isEmptyWithTrim(t.getUsername()))
			throw new UnauthorizedException("Ingrese el Usuario");

		JSONObject result = authService.loginInventarioByUser(t.getUsername());

		if (!result.has("useusr")) {
			throw new UnauthorizedException("Credenciales inválidas");
		}

		AutorizacionResponse response = new AutorizacionResponse();
		response.setDe(result.getString("de"));
		response.setUseusr(result.getString("useusr"));
		response.setUsecod(result.getInt("usecod"));
		response.setGrucod(result.getString("grucod"));
		response.setGrudes(result.getString("grudes"));
		response.setSisent(result.getString("sisent"));
		response.setSiscod(result.getInt("siscod"));
		response.setCodalmInv(result.getString("codalm_inv"));
		response.setUsenam(result.getString("usenam"));
		response.setToken(jwtTokenUtil.generateToken(response));
		response.setRefreshToken(jwtTokenUtil.generateRefreshToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse refreshToken(String refreshToken) {
		if (GenericUtil.isEmptyWithTrim(refreshToken)) {
			throw new UnauthorizedException("Refresh token es requerido");
		}

		if (!jwtTokenUtil.validateToken(refreshToken)) {
			throw new UnauthorizedException("Refresh token inválido o expirado");
		}

		AutorizacionResponse userInfo = jwtTokenUtil.getInfoFromToken(refreshToken);

		AutorizacionResponse response = new AutorizacionResponse();
		response.setUseusr(userInfo.getUseusr());
		response.setUsecod(userInfo.getUsecod());
		response.setGrucod(userInfo.getGrucod());
		response.setNombre(userInfo.getNombre());
		response.setToken(jwtTokenUtil.generateToken(response));
		return response;
	}

	@Override
	public AutorizacionResponse getUser(TokenRequest t) {
		AutorizacionResponse response = jwtTokenUtil.getInfoFromToken(t.getToken()); 
		JSONObject result = authService.loginByUser(response.getUseusr());
	
		if (result.isEmpty() || !result.has("usecod")) {
			throw new BadCredentialsException("Token inválido o usuario no encontrado");
		}
		return response;
	}

	@Override
	public AutorizacionResponse getUserFromTokenBartolito(TokenRequest t) {
		AutorizacionResponse response = jwtTokenUtil.getInfoFromToken(t.getToken()); 
		JSONObject result = authService.loginBartolitoByUser(response.getUseusr());
	
		if (result.isEmpty() || !result.has("usecod")) {
			throw new BadCredentialsException("Token inválido o usuario no encontrado");
		}
		return response;
	}

	@Override
	public AutorizacionResponse getUserFromTokenInventario(TokenRequest t) {
		AutorizacionResponse response = jwtTokenUtil.getInfoFromToken(t.getToken()); 
		JSONObject result = authService.loginInventarioByUser(response.getUseusr());
	
		if (result.isEmpty() || !result.has("usecod")) {
			throw new BadCredentialsException("Token inválido o usuario no encontrado");
		}
		return response;
	}

}
