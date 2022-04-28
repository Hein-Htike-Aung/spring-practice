package com.example.module04customloginlogout.security;

import org.springframework.security.authentication.BadCredentialsException;

public class PasswordCredentialException extends BadCredentialsException {
    public PasswordCredentialException(String msg) {
        super(msg);
    }
}
