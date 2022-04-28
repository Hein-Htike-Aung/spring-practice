package com.hha.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SpringBean02 {

    @Value("10.9")
    private double price;

    @Value("Xiaoting")
    private String name;
}
