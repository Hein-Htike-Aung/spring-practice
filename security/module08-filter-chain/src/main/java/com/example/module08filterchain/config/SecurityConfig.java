package com.example.module08filterchain.config;

import com.example.module08filterchain.security.AuthorizationKeyFilter;
import com.example.module08filterchain.security.AuthorizedLoggerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthorizationKeyFilter authorizationKeyFilter;

    @Autowired
    private AuthorizedLoggerFilter authorizedLoggerFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("karina").password("12345").roles("ADMIN").build();

        inMemoryUserDetailsManager.createUser(user);

        auth.userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        http
                .addFilterBefore(this.authorizationKeyFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(this.authorizedLoggerFilter, BasicAuthenticationFilter.class);
    }
}
