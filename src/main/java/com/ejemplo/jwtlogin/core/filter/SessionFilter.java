package com.ejemplo.jwtlogin.core.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ejemplo.jwtlogin.core.audit.UserSesion;
import com.ejemplo.jwtlogin.dto.GenericUtil;


 
public class SessionFilter implements Filter{

	private UserSesion usersion;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		usersion = (UserSesion) WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean("userSesion");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String usuario = httpServletRequest.getHeader("useusr");
		String rolCodigo = httpServletRequest.getHeader("grucod");
		String usuarioId = httpServletRequest.getHeader("usecod");
		if(GenericUtil.isNotEmpty(usuario)) {
			usersion.getRegistro().setUseusr(usuario);
		}
		if(GenericUtil.isNotEmpty(rolCodigo)) {
			usersion.getRegistro().setGrucod(rolCodigo);
		}
		 
		if(GenericUtil.isNotEmpty(usuarioId)) {
			usersion.getRegistro().setUsecod(Integer.parseInt(usuarioId));
		} 
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
