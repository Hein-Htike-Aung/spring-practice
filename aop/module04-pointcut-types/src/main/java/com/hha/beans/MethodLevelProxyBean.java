package com.hha.beans;

import com.hha.annotations.MethodLevelProxyAnnotation;
import org.springframework.stereotype.Component;

@Component

public class MethodLevelProxyBean {

    @MethodLevelProxyAnnotation
    public void annotation() {

    }

    // Execution Pointcut
    public void execution() {

    }

}
