package com.example.module01jwtauthentication.authentication.filter;

import com.example.module01jwtauthentication.authentication.proxy.AuthenticationServerProxy;
import com.example.module01jwtauthentication.authentication.token.UsernameOtpToken;
import com.example.module01jwtauthentication.authentication.token.UsernamePasswordToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
/*
 * Responsibility for Authentication
 * */
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationServerProxy authenticationServerProxy;

    @Value("${jwt.signing.key}")
    private String signingKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String otp = request.getHeader("otp");

        if (otp == null) {

            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

            // authenticate with custom token
            authenticationManager.authenticate(usernamePasswordToken);
        } else {

            UsernameOtpToken usernameOtpToken = new UsernameOtpToken(username, otp);

            // authenticate with custom token
            authenticationManager.authenticate(usernameOtpToken);

            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));

            String jwt = Jwts.builder()
                    .setClaims(Map.of("username", username))
                    .signWith(key)
                    .compact();

            // set Response's Header with jwt key
            response.setHeader("Authorization", jwt);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        return !request.getServletPath().equals("/login");
    }


}
