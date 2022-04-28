package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@PropertySources({
        @PropertySource("file:app-home/app-default.properties"),
        @PropertySource("classpath:/app-default.properties")
})
public class Config {

}
