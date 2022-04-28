package com.example.module01jwtauthentication.authentication.provider;

import com.example.module01jwtauthentication.authentication.proxy.AuthenticationServerProxy;
import com.example.module01jwtauthentication.authentication.token.UsernameOtpToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernameOtpAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationServerProxy authenticationServerProxy;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String otp = authentication.getCredentials().toString();

        boolean authenticateWithOtp = authenticationServerProxy.checkOtp(username, otp);

        if (authenticateWithOtp) {
            return new UsernameOtpToken(username, otp);
        } else {
            throw new BadCredentialsException("Otp is not correct.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernameOtpToken.class.isAssignableFrom(authentication);
    }
}
