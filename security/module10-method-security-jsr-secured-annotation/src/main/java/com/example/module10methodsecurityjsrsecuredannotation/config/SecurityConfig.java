package com.example.module10methodsecurityjsrsecuredannotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        securedEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("karina").password("12345").roles("ADMIN").build();
        var user2 = User.withUsername("xiaoting").password("12345").roles("MANAGER").build();

        inMemoryUserDetailsManager.createUser(user1);
        inMemoryUserDetailsManager.createUser(user2);

        auth.userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
}
