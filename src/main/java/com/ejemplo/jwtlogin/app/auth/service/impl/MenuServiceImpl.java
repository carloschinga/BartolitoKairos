package com.ejemplo.jwtlogin.app.auth.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.auth.service.MenuService;
import com.ejemplo.jwtlogin.app.security.repository.MenuRepository;
import com.ejemplo.jwtlogin.core.service.ServiceBase;

@Service
public class MenuServiceImpl extends ServiceBase implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public JSONArray obtenerPaginasPorGrupo(String grucod) {
		String response = menuRepository.getPaginasPorGrupo(grucod);
	    JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("paginasXGrupo"); 
	}

}
