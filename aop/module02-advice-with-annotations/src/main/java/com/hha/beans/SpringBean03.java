package com.hha.beans;

import com.hha.annotations.AroundInvocation;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SpringBean03 {

    @AroundInvocation
    public void print() {

        System.out.println(getClass().getSimpleName() + " within print()");
    }
}
