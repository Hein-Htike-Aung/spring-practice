package com.hha.prototype.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class PrototypeBean02 {

    private final PrototypeBean01 prototypeBean01;

    public PrototypeBean02(PrototypeBean01 prototypeBean01) {
        this.prototypeBean01 = prototypeBean01;
    }

    public void print(){
        System.out.println(getClass().getSimpleName() + " -> " + this.prototypeBean01);
    }

}
