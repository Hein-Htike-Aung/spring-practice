package com.example.module06custmizinmemoryuserdetailsmanager.config;

import com.example.module06custmizinmemoryuserdetailsmanager.entity.User;
import com.example.module06custmizinmemoryuserdetailsmanager.security.CustomInMemoryUserDetailsManager;
import com.example.module06custmizinmemoryuserdetailsmanager.security.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user1 = new CustomUserDetails(new User("karina", "12345", "read"));
        UserDetails user2 = new CustomUserDetails(new User("xiaoting", "12345", "read"));

        CustomInMemoryUserDetailsManager customInMemoryUserDetailsManager =
                new CustomInMemoryUserDetailsManager(List.of(user1, user2));

        auth.userDetailsService(customInMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

}
