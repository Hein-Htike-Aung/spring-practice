package com.example.module01jwtauthentication.authentication.proxy;

import com.example.module01jwtauthentication.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

/*
 * To interact with Auth server
 * */
@Component
public class AuthenticationServerProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${base.url}")
    private String baseUrl;

    public void checkAuth(String username, String password) {
        var user = new User();
        user.setUsername(username);
        user.setPassword(password);

        var request = new HttpEntity<>(user);
        restTemplate.postForEntity(baseUrl + "/users/auth", request, Void.class);

    }

    public boolean checkOtp(String username, String otp) {

        var user = new User();
        user.setUsername(username);
        user.setOtp(otp);

        var request = new HttpEntity<>(user);
        var responseStatus = restTemplate.postForEntity(baseUrl + "/users/check/otp", request, Void.class);

        return responseStatus.getStatusCode().equals(HttpStatus.OK);

    }
}
