package com.example.module11custmizhaspermission.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Users {

    private String name;

    private List<String> roles;

    private List<String> authorities;
}
