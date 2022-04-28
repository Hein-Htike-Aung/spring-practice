package com.example.module08filterchain.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class AuthorizationKeyFilter implements Filter {

    @Value("${authorization.key}")
    private String authorizationKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;

        if (authorizationKey.equals(request.getHeader("Authorization-Key"))) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
