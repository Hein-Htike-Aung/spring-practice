package com.example.module06custmizinmemoryuserdetailsmanager.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomInMemoryUserDetailsManager implements UserDetailsService {

    private final List<UserDetails> customUserDetailsList;

    public CustomInMemoryUserDetailsManager(List<UserDetails> customUserDetailsList) {
        this.customUserDetailsList = customUserDetailsList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.customUserDetailsList.stream()
                .filter(customUserDetails -> customUserDetails.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User Not found!!"));
    }
}
