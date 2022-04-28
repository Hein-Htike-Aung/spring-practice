package com.example.module02mvcscopes.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@RequestScope
@Component
public class RequestScopeBean {

    int value;
}
