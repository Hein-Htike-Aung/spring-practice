package com.example.module08filterchain.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorizedLoggerFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AuthorizedLoggerFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;

        logger.info("Header key -> " + request.getHeader("Authorization-Key"));

        filterChain.doFilter(request, response);
    }
}
