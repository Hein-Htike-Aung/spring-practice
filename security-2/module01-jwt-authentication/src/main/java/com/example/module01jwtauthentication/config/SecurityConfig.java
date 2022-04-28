package com.example.module01jwtauthentication.config;

import com.example.module01jwtauthentication.authentication.filter.InitialAuthenticationFilter;
import com.example.module01jwtauthentication.authentication.filter.JwtFilter;
import com.example.module01jwtauthentication.authentication.provider.UsernameOtpAuthenticationProvider;
import com.example.module01jwtauthentication.authentication.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private InitialAuthenticationFilter initialAuthenticationFilter;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Autowired
    private UsernameOtpAuthenticationProvider usernameOtpAuthenticationProvider;


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(this.usernamePasswordAuthenticationProvider);
        auth.authenticationProvider(this.usernameOtpAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http
                .addFilterAt(initialAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtFilter, BasicAuthenticationFilter.class);

        http.authorizeRequests().anyRequest().authenticated();
    }
}
