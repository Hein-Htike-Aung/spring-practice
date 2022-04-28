package com.example.module12methodbasedsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        System.out.println("Index");
        return "/commons/login";
    }

    @GetMapping("/home")
    public String home(
            Authentication authentication
    ) {

        System.out.println("getName" + authentication.getName());
        System.out.println("isAuthenticated " + authentication.isAuthenticated());
        System.out.println("getPrincipal " + authentication.getPrincipal()); // UserDetails
        System.out.println("getAuthorities" + authentication.getAuthorities()); // Roles

        System.out.println("getDetails " + authentication.getDetails());
        System.out.println("getCredentials " +authentication.getCredentials());


        // ROLE_SUPER_ADMIN
        List<String> authorities = authentication.getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.toList());

        for (String authority : authorities) {
            if (authority.equals(PREFIX + SUPER_ADMIN)) {
                return "/backend/admin-home";
            } else if (authority.equals(PREFIX + EMPLOYEE_ADMIN)) {
                return "forward:/employees";
            } else if (authority.equals(PREFIX + CUSTOMER_ADMIN)) {
                return "forward:/customers";
            } else if (authority.equals(PREFIX + DEPARTMENT_ADMIN)) {
                return "forward:/departments";
            }
        }
        return "/commons/error";

    }
}
