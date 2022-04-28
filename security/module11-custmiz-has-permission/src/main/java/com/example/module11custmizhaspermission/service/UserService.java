package com.example.module11custmizhaspermission.service;

import com.example.module11custmizhaspermission.Entity.Users;
import com.example.module11custmizhaspermission.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
   private UsersDao usersDao;

    @PostAuthorize("hasPermission(returnObject, 'ADMIN')")
    public Users getUsers(String name) {
        return this.usersDao.getUser(name);
    }

    @PreAuthorize("hasPermission(#name, null, 'ADMIN')")
    public Users getUsers2(String name) {
        return this.usersDao.getUser(name);
    }

}
