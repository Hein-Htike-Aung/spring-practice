package com.example.module04customloginlogout.security;

import com.example.module04customloginlogout.dao.UsersDao;
import com.example.module04customloginlogout.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDao userDao;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = this.userDao.findUsersByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with this username!!"));

        return new CustomUserDetails(users);
    }
}
