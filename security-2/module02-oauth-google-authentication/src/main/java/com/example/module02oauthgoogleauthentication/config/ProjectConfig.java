package com.example.module02oauthgoogleauthentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
        google cloud console -> APIs and Services -> Credentials -> OAuth 2.0 Client IDs
        http://localhost:8080/login/oauth2/code/google
        * */

        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/**").authenticated()
                .and()
                .oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
