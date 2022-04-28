package com.example.module03userdetailsserviceauthquery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        String usersByUsernameQuery = "select username, password, enabled from Users where username=?";
        String authoritiesByUsernameQuery = "select username, authority from Authorities where username=?";

        var userDetailsService = new JdbcUserDetailsManager(dataSource);
        userDetailsService.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsService.setAuthoritiesByUsernameQuery(authoritiesByUsernameQuery);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
