package com.example.module09methodsecurityauthorizeannotation.service;


import com.example.module09methodsecurityauthorizeannotation.entity.Authorities;
import com.example.module09methodsecurityauthorizeannotation.entity.Users;
import com.example.module09methodsecurityauthorizeannotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> inQueryLoginUser() {
        return this.userRepository.findLoginUser();
    }

    @PreAuthorize("hasAuthority('WRITE')")
    public Users preAuthorize(String name) {
        return this.userRepository.findFirstByName(name);
    }

    @PreAuthorize("#name.equals(authentication.principal.username)")
    public Users preAuthorize02(String name) {
        return this.userRepository.findFirstByName(name);
    }

    @PreFilter("filterObject.name.equals(authentication.name)")
    public List<Users> preFilter(List<Users> users) {
        return users;
    }

    @PostAuthorize("returnObject.authorities.get(0).role.equals('ADMIN')")
    public Users postAuthorize(String name) {
        return this.userRepository.findFirstByName(name);
    }

    @PostFilter("filterObject.name == authentication.getName()")
    public List<Users> postFilter() {
        return this.userRepository.findAll();
    }

    public List<Users> findAll() {
        return this.userRepository.findAll();
    }

}
