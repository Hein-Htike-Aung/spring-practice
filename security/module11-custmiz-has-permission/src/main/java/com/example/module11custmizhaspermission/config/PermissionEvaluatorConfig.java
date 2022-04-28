package com.example.module11custmizhaspermission.config;

import com.example.module11custmizhaspermission.security.CustomPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PermissionEvaluatorConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private CustomPermissionEvaluator customPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        var abstractSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();

        abstractSecurityExpressionHandler.setPermissionEvaluator(customPermissionEvaluator);

        return abstractSecurityExpressionHandler;
    }
}
