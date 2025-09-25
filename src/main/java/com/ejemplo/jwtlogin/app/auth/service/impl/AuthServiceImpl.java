package com.ejemplo.jwtlogin.app.auth.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.auth.service.AuthService;
import com.ejemplo.jwtlogin.app.security.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	// ===========================
	// LOGIN NORMAL
	// ===========================
	public JSONObject login(String username, String password) {
		String response = authRepository.loginUsuario("N", username, password);
		return new JSONObject(response);
	}

	@Override
	public JSONObject loginByUser(String username) {
		String response = authRepository.loginUsuarioByUsername("N", username);
		return new JSONObject(response);
	}

	// ===========================
	// LOGIN BARTOLITO
	// ===========================

	public JSONObject loginBartolito(String username, String passwordTexto) {
		// Convertir la contraseña a bytes tal como espera el procedimiento
		String hexEncoded = stringToHexWithPrefix(passwordTexto);
		if (hexEncoded.startsWith("0x")) {
			hexEncoded = hexEncoded.substring(2);
		}
		byte[] password = hexStringToByteArray(hexEncoded);

		String response = authRepository.loginUsuario2("B", username, password);

		return new JSONObject(response);
	}

	@Override
	public JSONObject loginBartolitoByUser(String username) {
		String response = authRepository.loginUsuarioByUsername("B", username);
		return new JSONObject(response);
	}

	// ===========================
	// LOGIN INVENTARIO
	// ===========================

	public JSONObject loginInventario(String username, String passwordTexto) {
		// Convertir la contraseña a bytes tal como espera el procedimiento
		String hexEncoded = stringToHexWithPrefix(passwordTexto);
		if (hexEncoded.startsWith("0x")) {
			hexEncoded = hexEncoded.substring(2);
		}
		byte[] password = hexStringToByteArray(hexEncoded);

		String response = authRepository.loginUsuario2("I", username, password);

		return new JSONObject(response);
	}

	@Override
	public JSONObject loginInventarioByUser(String username) {
		String response = authRepository.loginUsuarioByUsername("I", username);
		return new JSONObject(response);
	}

	// Método para convertir string a representación hexadecimal con prefijo 0x
	private static String stringToHexWithPrefix(String input) {
		StringBuilder hexString = new StringBuilder("0x");
		byte[] bytes = input.getBytes();

		for (byte b : bytes) {
			hexString.append(String.format("%02x", b));
		}

		return hexString.toString();
	}

	// Helper method to convert hex string to byte array
	private static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	@Override
	public JSONObject loginUsuarioByUsername(String tipo, String username) {
		String response = authRepository.loginUsuarioByUsername(tipo, username);
		return new JSONObject(response);
	}

}
