package com.ejemplo.jwtlogin.core.facade;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.core.audit.UserSesion;
import com.ejemplo.jwtlogin.core.exception.InternalException;

import lombok.extern.slf4j.Slf4j;

@Service("facadeBase")
@Slf4j
public class FacadeBase {

	@Autowired
	protected ModelMapper modelMapper;
	
	@Autowired
	protected UserSesion userSesion;
	
	/*
	@Value("${message.global.update.password}")
	protected String messageUpdatePassword;
	@Value("${message.global.reset.password}")
	protected String messageResetPassword;
	
	@Value("${message.global.save}")
	protected String messageSave;
	@Value("${message.global.update}")
	protected String messageUpdate;
	@Value("${message.global.delete}")
	protected String messageDelete;*/

	
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
