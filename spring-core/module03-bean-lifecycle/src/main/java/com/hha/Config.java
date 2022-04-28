package com.hha;

import com.hha.bean.Bean01;
import com.hha.bean.Bean02;
import com.hha.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SpringBean springBean(Bean01 bean01, Bean02 bean02) {
        return new SpringBean(bean01, bean02);
    }

}
