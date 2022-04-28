package com.hha.scanner;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@ComponentScan(
        basePackages = "com.hha.bean",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*SpringBean03"),
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean")

)
public class Config {
}
