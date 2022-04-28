package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class SpringBean01 {

    @Value("#{springBean02.price}")
    private double springBean01_price;

    @Value("#{springBean02.name.toUpperCase()}")
    private String springBean01_name;

    @Value("#{${application.id} + 100}")
    private int application_id;

    @Value("#{${application.double}}")
    private double application_double;

    @Value("#{'${application.name}'.toUpperCase()}")
    private String application_name;

    @Value("#{${application.map}}")
    private Map<String, Integer> application_map;

    @PostConstruct
    public void init() {
        System.out.println(springBean01_price);
        System.out.println(springBean01_name);
        System.out.println(application_id);
        System.out.println(application_double);
        System.out.println(application_name);
        System.out.println(application_map);
    }
}
