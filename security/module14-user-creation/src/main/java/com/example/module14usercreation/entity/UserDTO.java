package com.example.module14usercreation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO { // For Registration & Password Changing

    private String username;

    private String password;

    private String oldPassword;

    private String repeatedPassword;

    public UserDTO() {
    }
}
