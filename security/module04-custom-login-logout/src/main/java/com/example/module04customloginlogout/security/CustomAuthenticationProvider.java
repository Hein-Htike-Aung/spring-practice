package com.example.module04customloginlogout.security;

import com.example.module04customloginlogout.entity.enums.EncryptionAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();

        // check username
        CustomUserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

        switch (userDetails.getUsers().getAlgorithm()) {
            case BCRYPT:
                return checkPassword(rawPassword, userDetails, new BCryptPasswordEncoder());
            case SCRYPT:
                return checkPassword(rawPassword, userDetails, new SCryptPasswordEncoder());

        }

        throw new BadCredentialsException("There is something wrong!!!");
    }

    private UsernamePasswordAuthenticationToken checkPassword(String rawPassword, CustomUserDetails userDetails, PasswordEncoder passwordEncoder) {

        if (passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        } else {
            throw new PasswordCredentialException("Password doesn't match");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
