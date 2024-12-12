package com.edu.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    public boolean hasAccess(){
        //recuperar la informacion del usuario logeado


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        log.info("username: {}", username + " has access");
        auth.getAuthorities().forEach(authority -> log.info("authority: {}", authority));
        return true;

    }
}
