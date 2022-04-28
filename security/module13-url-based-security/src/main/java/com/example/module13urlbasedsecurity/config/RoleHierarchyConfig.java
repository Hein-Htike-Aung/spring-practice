package com.example.module13urlbasedsecurity.config;

import com.example.module13urlbasedsecurity.security.RolesHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.example.module13urlbasedsecurity.security.UserRoles.*;


@Configuration
public class RoleHierarchyConfig {

    @Bean
    public RoleHierarchy roleHierarchy() {

        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(
                new RolesHierarchyBuilder()
                        .append(SUPER_ADMIN, EMPLOYEE_ADMIN)
                        .append(EMPLOYEE_ADMIN, EMPLOYEE_READ)
                        .append(EMPLOYEE_ADMIN, EMPLOYEE_DETAILS)
                        .append(EMPLOYEE_ADMIN, EMPLOYEE_CREATE)
                        .append(EMPLOYEE_ADMIN, EMPLOYEE_UPDATE)
                        .append(EMPLOYEE_ADMIN, EMPLOYEE_DELETE)

                        .append(SUPER_ADMIN, CUSTOMER_ADMIN)
                        .append(CUSTOMER_ADMIN, CUSTOMER_READ)
                        .append(CUSTOMER_ADMIN, CUSTOMER_DETAILS)
                        .append(CUSTOMER_ADMIN, CUSTOMER_CREATE)
                        .append(CUSTOMER_ADMIN, CUSTOMER_UPDATE)
                        .append(CUSTOMER_ADMIN, CUSTOMER_DELETE)

                        .append(SUPER_ADMIN, DEPARTMENT_ADMIN)
                        .append(DEPARTMENT_ADMIN, DEPARTMENT_READ)
                        .append(DEPARTMENT_ADMIN, DEPARTMENT_DETAILS)
                        .append(DEPARTMENT_ADMIN, DEPARTMENT_CREATE)
                        .append(DEPARTMENT_ADMIN, DEPARTMENT_UPDATE)
                        .append(DEPARTMENT_ADMIN, DEPARTMENT_DELETE)
                        .build()
        );
        return roleHierarchy;
    }
}
