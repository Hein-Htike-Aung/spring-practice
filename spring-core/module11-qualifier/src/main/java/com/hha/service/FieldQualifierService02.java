package com.hha.service;

import com.hha.beans.qualifier01.FieldQualifier;
import com.hha.beans.qualifier02.ClassQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FieldQualifierService02 {

    @Autowired
    @Qualifier("class-qualifier-impl01")
    private ClassQualifier classQualifierImpl01;

    @Autowired
    @Qualifier("class-qualifier-impl02")
    private ClassQualifier classQualifierImpl02;

    public void print() {
        System.out.println(classQualifierImpl01.getClass().getSimpleName());
        System.out.println(classQualifierImpl02.getClass().getSimpleName());
    }
}
