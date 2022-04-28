package com.hha;

import com.hha.singleton.beans.*;
import com.hha.singleton_bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public InterImpl01 interImpl01() {
        return new InterImpl01();
    }

    @Bean("SecondInterImpl")
    public InterImpl02 interImpl02() {
        return new InterImpl02();
    }

    @Bean({"thirdInterImpl", "interImpl3rd"})
    public InterImpl03 interImpl03() {
        return new InterImpl03();
    }

//    @Bean
//    public SuperBean superBean(Inter interImpl01){
//        return new SuperBean(interImpl01);
//    }

//    @Bean
//    public SuperBean superBean(Inter SecondInterImpl){
//        return new SuperBean(SecondInterImpl);
//    }

    @Bean
    public SuperBean superBean(Inter interImpl3rd){
        return new SuperBean(interImpl3rd);
    }

}
