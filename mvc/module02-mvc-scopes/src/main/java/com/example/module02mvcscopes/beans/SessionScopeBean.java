package com.example.module02mvcscopes.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@SessionScope
@Component
public class SessionScopeBean {

    int value;
}
