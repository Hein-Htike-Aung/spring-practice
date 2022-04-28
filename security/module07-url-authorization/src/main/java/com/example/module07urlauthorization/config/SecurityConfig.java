package com.example.module07urlauthorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("karina").password("12345").roles("ADMIN").build();
        var user2 = User.withUsername("xiaoting").password("12345").roles("MANAGER").build();
        var user3 = User.withUsername("ningning").password("12345").roles("CUSTOMER").build();

        inMemoryUserDetailsManager.createUser(user1);
        inMemoryUserDetailsManager.createUser(user2);
        inMemoryUserDetailsManager.createUser(user3);

        auth.userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        http.authorizeRequests()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .mvcMatchers("/manager").hasAnyRole("ADMIN", "MANAGER")
                .mvcMatchers(HttpMethod.GET, "/get").permitAll()
                .mvcMatchers(HttpMethod.POST, "/post").authenticated()
                .mvcMatchers(HttpMethod.GET, "/double/**").authenticated()
                .anyRequest().authenticated();

        /*
        * For Testing
        * disable means allow post methods not to be forbidden
        * Cuz Post method need csrf token
        * */
        http.csrf().disable();
    }
}
