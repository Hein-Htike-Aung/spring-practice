package com.example.module14usercreation.service;

import com.example.module14usercreation.dao.UserDao;
import com.example.module14usercreation.entity.UserDTO;
import com.example.module14usercreation.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserProfileService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users findUsersByUsername(String username) {
        return this.userDao.findUsersByUsername(username);
    }

    public boolean isPasswordChangeable(UserDTO passwordChanger) {


        Users user = this.userDao.findUsersByUsername(getAuthentication().getName());

        // check old password from database with confirmed password
        if(!passwordEncoder.matches(passwordChanger.getOldPassword(), user.getPassword())){
            return false;
        }

        return true;
    }

    @Transactional
    public void changePassword(UserDTO passwordChanger) {

        Users user = this.userDao.findUsersByUsername(getAuthentication().getName());

        user.setPassword(passwordEncoder.encode(passwordChanger.getPassword()));

        this.userDao.save(user);

    }

    public Authentication getAuthentication(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication();
    }


}
