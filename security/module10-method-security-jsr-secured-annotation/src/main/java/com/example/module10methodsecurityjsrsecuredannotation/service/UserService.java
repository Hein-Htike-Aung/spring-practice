package com.example.module10methodsecurityjsrsecuredannotation.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@Service
public class UserService {

    @Secured("ROLE_ADMIN")
    public String getUserUsingSecured(){
        return "Secured User";
    }

    @RolesAllowed("ROLE_ADMIN")
    public String getUserUsingRolesAllowed() {
        return "RolesAllowed User";
    }
}
