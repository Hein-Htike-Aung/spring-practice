package com.example.module09methodsecurityauthorizeannotation.config;

import org.apache.catalina.startup.WebappServiceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("karina").password("12345").roles("ADMIN").authorities("WRITE", "READ").build();
        var user2 = User.withUsername("xiaoting").password("12345").roles("MANAGER").authorities("READ").build();

        inMemoryUserDetailsManager.createUser(user);
        inMemoryUserDetailsManager.createUser(user2);

        auth.userDetailsService(inMemoryUserDetailsManager)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
