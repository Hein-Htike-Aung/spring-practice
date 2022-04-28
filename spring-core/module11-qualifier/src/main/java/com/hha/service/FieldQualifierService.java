package com.hha.service;

import com.hha.beans.qualifier01.FieldQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FieldQualifierService {

    @Autowired
    @Qualifier("fieldQualifierImpl01")
    private FieldQualifier fieldQualifierImpl01;

    @Autowired
    @Qualifier("fieldQualifierImpl02")
    private FieldQualifier fieldQualifierImpl02;

    public void print() {
        System.out.println(fieldQualifierImpl01.getClass().getSimpleName());
        System.out.println(fieldQualifierImpl02.getClass().getSimpleName());
    }
}
