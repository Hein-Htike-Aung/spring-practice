package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@PropertySources({
        @PropertySource("classpath:/application.properties")
})
public class Config {
}
