package com.example.module01jwtauthentication.authentication.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordToken extends UsernamePasswordAuthenticationToken{


    public UsernamePasswordToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UsernamePasswordToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
