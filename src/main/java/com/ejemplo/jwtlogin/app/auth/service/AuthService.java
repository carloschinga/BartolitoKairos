package com.ejemplo.jwtlogin.app.auth.service;

import org.json.JSONObject;

public interface AuthService {
	
	JSONObject login(String username, String password); // PRUEBA ACTUAL 
	
	JSONObject loginBartolito(String username, String passwordTexto); // VALIDA PICKING 
	
	JSONObject loginInventario(String username, String passwordTexto); // VALIDA MODULO INVENTARIO 
	
	JSONObject loginUsuarioByUsername(String tipo, String username);
	
	JSONObject loginInventarioByUser(String username);

	JSONObject loginBartolitoByUser(String username);

	JSONObject loginByUser(String username);
}
