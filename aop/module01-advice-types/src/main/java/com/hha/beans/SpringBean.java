package com.hha.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    public String sayHello(String str) {

        return "Return Value";
    }

    public void noReturnSayHello() {

    }

    public String throwingException() {
        throw new RuntimeException("Exception has thrown!!");
    }

    public String aroundAspectMethod(String str) {

        return "AroundMethod Return Value";
    }


}
