package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CGILIBProxyBean {

    public void publicMethod(){
    }

    protected void protectedMethod() {
        // Self invocation doesn't work
        privateMethod();
    }

    private void privateMethod() {

    }

    void noModifierMethod() {
    }
}
