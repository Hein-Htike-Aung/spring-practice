package com.example.module2oauthgithubauthentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
        * Github -> Settings -> Developer settings -> OAuth Apps -> New OAuth App
        * */
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/**").authenticated()
                .and()
                .oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
