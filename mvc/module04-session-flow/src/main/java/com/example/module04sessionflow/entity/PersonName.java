package com.example.module04sessionflow.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PersonName {

    @NotEmpty
    private String name;
}
