package com.example.module01jwtauthentication.authentication.provider;

import com.example.module01jwtauthentication.authentication.proxy.AuthenticationServerProxy;
import com.example.module01jwtauthentication.authentication.token.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationServerProxy authenticationServerProxy;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        authenticationServerProxy.checkAuth(username, password);

        return new UsernamePasswordToken(username, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return UsernamePasswordToken.class.isAssignableFrom(authentication);
    }
}
