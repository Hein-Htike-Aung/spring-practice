package com.example.module05inmemoryuserdetailsmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
public class InMemoryUserDetailsConfig02 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user = User
                .withUsername("karina")
                .password("12345")
                .authorities("read")
                .build();

        inMemoryUserDetailsManager.createUser(user);

        auth.userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
