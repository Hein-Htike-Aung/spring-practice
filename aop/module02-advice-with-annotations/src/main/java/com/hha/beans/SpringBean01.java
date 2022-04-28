package com.hha.beans;

import com.hha.annotations.AroundInvocation;
import com.hha.annotations.BeforeInvocation;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SpringBean01 {

    @BeforeInvocation
    public void print() {

        System.out.println(getClass().getSimpleName() + " within print()");

    }
}
