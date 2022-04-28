package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan
@PropertySources({
        @PropertySource("classpath:/application.properties"),
        @PropertySource("classpath:/application02.properties")
})
public class Config {
}
