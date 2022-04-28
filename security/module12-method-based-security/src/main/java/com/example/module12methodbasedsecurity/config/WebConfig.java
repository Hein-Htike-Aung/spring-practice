package com.example.module12methodbasedsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleHierarchy roleHierarchy;

    public DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler() {

        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(passwordEncoder.encode("john"))
                .roles(SUPER_ADMIN)
                .and()

                .withUser("emma")
                .password(passwordEncoder.encode("emma"))
                .roles(EMPLOYEE_ADMIN)
                .and()

                .withUser("lucas")
                .password(passwordEncoder.encode("lucas"))
                .roles(CUSTOMER_ADMIN)
                .and()

                .withUser("tom")
                .password(passwordEncoder.encode("tom"))
                .roles(DEPARTMENT_ADMIN);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .expressionHandler(defaultWebSecurityExpressionHandler())

                .mvcMatchers("/employees").hasRole(EMPLOYEE_READ)
                .mvcMatchers("/departments").hasRole(DEPARTMENT_READ)
                .mvcMatchers("/customers").hasRole(CUSTOMER_READ)
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .failureUrl("/login/error")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()

                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }
}
