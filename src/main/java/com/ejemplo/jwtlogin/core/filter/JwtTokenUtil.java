package com.ejemplo.jwtlogin.core.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ejemplo.jwtlogin.config.SecurityUtil;
import com.ejemplo.jwtlogin.dto.model.auth.AutorizacionResponse;
import com.google.gson.Gson;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6816353449960388060L;

	private static final SecretKey SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public AutorizacionResponse getInfoFromToken(String token) {
		AutorizacionResponse autorizacionResponse = new AutorizacionResponse();
		Claims claims = getAllClaimsFromToken(token);
		autorizacionResponse.setUseusr(claims.getSubject());
		autorizacionResponse.setGrucod(claims.get("grucod").toString());
		autorizacionResponse.setUsecod((Integer) (claims.get("usecod")));
		return autorizacionResponse;
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(SIGNING_KEY).build().parseClaimsJws(token);
		return jws.getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

	public String generateToken(AutorizacionResponse t) {
		return doGenerateToken(t);
	}

	private String doGenerateToken(AutorizacionResponse t) {
		log.debug("doGenerateToken: {}", new Gson().toJson(t));
		Claims claims = Jwts.claims().setSubject(t.getUseusr());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(t.getGrucod()));
		claims.put("scopes", authorities);
		claims.put("usecod", t.getUsecod());
		claims.put("grucod", t.getGrucod());
		return Jwts.builder().setClaims(claims).setIssuer(SecurityUtil.ISSUER_INFO)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + SecurityUtil.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
				.signWith(SIGNING_KEY, SignatureAlgorithm.HS256).compact();
	}

	public String generateRefreshToken(AutorizacionResponse t) {
		Claims claims = Jwts.claims().setSubject(t.getUseusr());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(t.getGrucod()));
		claims.put("scopes", authorities);
		claims.put("usecod", t.getUsecod());
		claims.put("grucod", t.getGrucod());
		return Jwts.builder().setClaims(claims).setIssuer(SecurityUtil.ISSUER_INFO)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + SecurityUtil.REFRESH_TOKEN_VALIDITY_SECONDS * 1000))
				.signWith(SIGNING_KEY, SignatureAlgorithm.HS256).compact();
	}

}
