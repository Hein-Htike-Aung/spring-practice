package com.example.module11custmizhaspermission.security;

import com.example.module11custmizhaspermission.Entity.Users;
import com.example.module11custmizhaspermission.dao.UsersDao;
import com.example.module11custmizhaspermission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Object targetDomainObject,
            Object permission) {

        boolean admin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(permission));

        Users users = (Users) targetDomainObject;

        return admin || users.getName().equals(authentication.getName());

    }

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Serializable targetId,
            String targetType,
            Object permission) {

        boolean admin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(permission));

        String name = targetId.toString();
        Users users = this.usersDao.getUsersMap().get(name);

        return admin || users.getName().equals(authentication.getName());
    }
}
