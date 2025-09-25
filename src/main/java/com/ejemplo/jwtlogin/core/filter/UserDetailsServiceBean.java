package com.ejemplo.jwtlogin.core.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceBean  {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> User.withUsername(username)
                .password("dummy")
                .roles("USER")
                .build();
    }
}