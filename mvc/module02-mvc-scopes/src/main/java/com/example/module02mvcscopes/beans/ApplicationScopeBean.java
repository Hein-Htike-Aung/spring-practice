package com.example.module02mvcscopes.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Data
@ApplicationScope
@Component
public class ApplicationScopeBean {

    int value;
}
