package com.hha.prototype.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class PrototypeBean01 {

    /*
    * If Prototype Bean has Lazy Instantiation
    * can't use lifecycle methods
    * */

    private final PrototypeBean02 prototypeBean02;

    public PrototypeBean01(@Lazy PrototypeBean02 prototypeBean02) {
        this.prototypeBean02 = prototypeBean02;
    }

    public void print(){
        System.out.println(getClass().getSimpleName() + " -> " + this.prototypeBean02);
    }

}
