package com.example.module01customauthenticationprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Student {

    private int studentId;
    private String studentName;

    public Student() {
    }
}
