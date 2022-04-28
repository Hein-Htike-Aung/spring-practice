package com.example.module01jwtauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private String otp;

    public User() {
    }
}
