package com.example.counterservice.ds;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class StatefulCounter {

    private int counter;

    public void countUp(){
        ++ this.counter;
    }

    public int getCounter() {
        return counter;
    }
}
