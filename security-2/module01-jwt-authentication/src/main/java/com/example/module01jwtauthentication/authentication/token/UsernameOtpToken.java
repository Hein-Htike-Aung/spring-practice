package com.example.module01jwtauthentication.authentication.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsernameOtpToken extends UsernamePasswordAuthenticationToken {

    public UsernameOtpToken(Object principal, Object credentials) {
        super(principal, credentials);
    }


}
