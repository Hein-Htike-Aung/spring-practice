package com.hha.beans;

import com.hha.annotations.ArgumentLevelProxyAnnotation;
import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class ArgumentLevelProxyBean {

    public void args(String str, String str2, int i) {

    }

    public void atArgs(Employee employee) {
    }
}
