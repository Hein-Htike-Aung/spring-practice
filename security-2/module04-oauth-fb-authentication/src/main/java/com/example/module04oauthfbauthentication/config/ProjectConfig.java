package com.example.module04oauthfbauthentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
        * https://developers.facebook.com
        * */

        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/**").authenticated()
                .and()
                .oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
