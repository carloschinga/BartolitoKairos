package com.ejemplo.jwtlogin.app.auth.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.auth.facade.MenuFacade;
import com.ejemplo.jwtlogin.dto.model.menu.MenuRequest;
import com.ejemplo.jwtlogin.dto.model.menu.MenuResponse;

@RestController
@RequestMapping("/menu")
public class MenuRestController {
	@Autowired
	private MenuFacade menuFacade;

	@PostMapping("/paginasxgrupo")
	public List<MenuResponse> listarPaginasXGrupo2(@RequestBody MenuRequest request) {
		return menuFacade.obtenerPaginasPorGrupo2(request);
	}
}
