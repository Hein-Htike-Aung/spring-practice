package com.hha;

import com.hha.singleton.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@ComponentScan
public class Config {

    @Bean
    @Profile({"db", "InMemory", "mysql"})
    public MultiProfileBean multiProfileBean() {
        return new MultiProfileBean();
    }

    @Bean
    @Profile("db")
    public SingleProfile singleProfileImpl01() {
        return new SingleProfileImpl01();
    }

    @Bean
    @Profile("InMemory")
    public SingleProfile singleProfileImpl02() {
        return new SingleProfileImpl02();
    }

    @Bean
    @Profile("mysql")
    public SingleProfile singleProfileImpl03() {
        return new SingleProfileImpl03();
    }
}
