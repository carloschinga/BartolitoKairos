package com.ejemplo.jwtlogin.app.auth.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.app.auth.facade.MenuFacade;
import com.ejemplo.jwtlogin.app.auth.service.AuthService;
import com.ejemplo.jwtlogin.app.auth.service.MenuService;
import com.ejemplo.jwtlogin.core.facade.FacadeBase;
import com.ejemplo.jwtlogin.dto.model.menu.MenuRequest;
import com.ejemplo.jwtlogin.dto.model.menu.MenuResponse;

@Component
public class MenuFacadeImpl extends FacadeBase implements MenuFacade {

	@Autowired
	private AuthService authService;

	@Autowired
	private MenuService menuService;

	@Override
	public List<MenuResponse> obtenerPaginasPorGrupo2(MenuRequest t) {
		if (t.getTipo() == null || t.getTipo().isEmpty()) {
			t.setTipo("N");
		}
		
		String username = userSesion.getRegistro().getUseusr();

		JSONObject response = authService.loginUsuarioByUsername(t.getTipo(), username);

		String grucod = response.getString("grucod"); // aquí obtienes SUPERV

		List<MenuResponse> collection = new ArrayList<>();

		JSONArray paginas = menuService.obtenerPaginasPorGrupo(grucod); 

		for (int i = 0; i < paginas.length(); i++) {

			JSONObject pag = paginas.getJSONObject(i);
			
			MenuResponse menuResponse = new MenuResponse();
			menuResponse.setPagId(pag.getInt("pag_id"));
			menuResponse.setPagNombre(pag.getString("pag_nombre"));
			menuResponse.setPagRuta(pag.getString("pag_ruta"));
			menuResponse.setTipMenu(pag.getString("tip_menu"));
			menuResponse.setPagPadre(pag.getInt("pag_padre"));
			menuResponse.setIClass(pag.getInt("iclass"));
			collection.add(menuResponse); 
		}

		return collection;
	}
}
