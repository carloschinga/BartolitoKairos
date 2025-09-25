package com.ejemplo.jwtlogin.app.auth.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.auth.facade.AuthFacade;
import com.ejemplo.jwtlogin.dto.model.auth.AutorizacionResponse;
import com.ejemplo.jwtlogin.dto.model.auth.LoginRequest;
import com.ejemplo.jwtlogin.dto.model.auth.TokenRequest;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

	@Autowired
	private AuthFacade authFacade;

	// ===========================
	// LOGIN NORMAL
	// ===========================
	@PostMapping("/login")
	public AutorizacionResponse login(@RequestBody LoginRequest request) {
		return authFacade.login(request);
	}

	@PostMapping("/loginByUsername")
	public AutorizacionResponse loginByUsername(@RequestBody LoginRequest request) {
		return authFacade.loginByUsername(request);
	}

	// ===========================
	// LOGIN BARTOLITO CAMBIOS
	// ===========================

	@PostMapping("/loginBartolito")
	public AutorizacionResponse loginBartolito(@RequestBody LoginRequest request) {
		return authFacade.loginBartolito(request);
	}

	@PostMapping("/loginBartolitoByUsername")
	public AutorizacionResponse loginBartolitoByUsername(@RequestBody LoginRequest request) {
		return authFacade.loginBartolitoByUsername(request);
	}

	// ===========================
	// LOGIN INVENTARIO
	// ===========================

	@PostMapping("/loginInventario")
	public AutorizacionResponse loginInventario(@RequestBody LoginRequest request) {
		return authFacade.loginInventario(request);
	}

	@PostMapping("/loginInventarioByUsername")
	public AutorizacionResponse loginInventarioByUsername(@RequestBody LoginRequest request) {
		return authFacade.loginInventarioByUsername(request);
	}

	// ===========================
	// OBTENER USUARIO DESDE TOKEN
	// ===========================

	@PostMapping("/getUser")
	public AutorizacionResponse getUser(@RequestBody TokenRequest request) {
		return authFacade.getUser(request);
	}

	@PostMapping("/getUserBartolito")
	public AutorizacionResponse getUserBartolito2(@RequestBody TokenRequest request) {
		return authFacade.getUserFromTokenBartolito(request);
	}

	@PostMapping("/getUserInventario")
	public AutorizacionResponse getUserInventario2(@RequestBody TokenRequest request) {
		return authFacade.getUserFromTokenInventario(request);
	}

	// ===========================
	// REFRESH
	// ===========================

	@PostMapping("/refresh")
	public ResponseEntity<AutorizacionResponse> refresh(@RequestBody Map<String, String> body) {
		String refreshToken = body.get("refreshToken");
		return ResponseEntity.ok(authFacade.refreshToken(refreshToken));
	}
}
