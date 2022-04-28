package com.example.module12methodbasedsecurity.security.annotations.customer;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.module12methodbasedsecurity.security.UserRoles.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Secured(PREFIX + CUSTOMER_UPDATE)
public @interface CustomerUpdate {
}
