package com.ejemplo.jwtlogin.core.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ejemplo.jwtlogin.config.SecurityUtil;
import com.ejemplo.jwtlogin.core.audit.UserSesion;
import com.ejemplo.jwtlogin.core.exception.UnauthorizedException;
import com.ejemplo.jwtlogin.dto.GenericUtil;
import com.ejemplo.jwtlogin.dto.model.auth.AutorizacionResponse;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserSesion usersion;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("doFilterInternal");
		String header = request.getHeader(SecurityUtil.HEADER_STRING);
		String username = null;
		String authToken = null;
		if (GenericUtil.isNotEmpty(header) && header.startsWith(SecurityUtil.TOKEN_PREFIX)) {
			authToken = header.replace(SecurityUtil.TOKEN_PREFIX, "");
			try {
				AutorizacionResponse tt = jwtTokenUtil.getInfoFromToken(authToken);
				if (GenericUtil.isNotEmpty(tt)) {
					username=tt.getUseusr();
					usersion.getRegistro().setUseusr((username));;
					usersion.getRegistro().setUsecod(tt.getUsecod());
					usersion.getRegistro().setGrucod(tt.getGrucod());
				}
			} catch (IllegalArgumentException e) {
				throw new UnauthorizedException("usuario del Token");
			} catch (ExpiredJwtException e) {
				throw new UnauthorizedException("usuario del Token");
			}
		}  
		if (!GenericUtil.isEmptyWithTrim(username) && GenericUtil.isNull(SecurityContextHolder.getContext().getAuthentication())) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

}