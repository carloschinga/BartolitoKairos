package com.ejemplo.jwtlogin.core.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.core.audit.UserSesion;
import com.ejemplo.jwtlogin.core.exception.InternalException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("serviceBase")
public class ServiceBase {

	@Autowired
	protected ModelMapper modelMapper;

	@Autowired
	protected UserSesion userSesion;

	protected void launchException(Exception e) {
		log.error(e.getMessage());
		if (e instanceof EntityNotFoundException) {
			throw new InternalException(e.getMessage());
		} else if (e instanceof MappingException) {
			throw new InternalException(e.getMessage());
		} else {
			throw new InternalException(e.getMessage());
		}
	}
}
