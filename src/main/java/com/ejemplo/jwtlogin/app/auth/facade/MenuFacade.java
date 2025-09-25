package com.ejemplo.jwtlogin.app.auth.facade;

import java.util.List;

import com.ejemplo.jwtlogin.dto.model.menu.MenuRequest;
import com.ejemplo.jwtlogin.dto.model.menu.MenuResponse;

public interface MenuFacade {
	List<MenuResponse> obtenerPaginasPorGrupo2(MenuRequest request);
}
