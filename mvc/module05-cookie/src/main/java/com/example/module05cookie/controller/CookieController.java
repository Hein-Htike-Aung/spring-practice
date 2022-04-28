package com.example.module05cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class CookieController {

    // curl -c cookie.txt http://localhost:8080/cookie/set-cookie
    @GetMapping("/cookie/set-cookie")
    @ResponseBody
    public String setCookie(
            HttpServletResponse httpServletResponse
    ){
        httpServletResponse.addCookie(new Cookie("cookie-value", "99999"));

        return "Successfully Set Cookie";
    }

    // curl -b cookie.txt http://localhost:8080/cookie/get-cookie
    @GetMapping("/cookie/get-cookie")
    @ResponseBody
    public String getCookieWithCookieValue(
            @CookieValue ("cookie-value") String value
    ){
        return "Cookie Value = " + value;
    }

    // curl -b cookie.txt http://localhost:8080/cookie/get-cookie2
    @GetMapping("/cookie/get-cookie2")
    @ResponseBody
    public String getCookieWithCookieValueRequiredFalse(
            @CookieValue (value = "cookie-value", required = false, defaultValue = "N/A") String value
    ){
        return "Cookie Value = " + value;
    }

    // curl -b cookie.txt http://localhost:8080/cookie/get-cookie3
    @GetMapping("/cookie/get-cookie3")
    @ResponseBody
    public String getCookieWithCookieValueOptional(
            @CookieValue (value = "cookie-value", required = false) Optional<String> value
    ){
        return "Cookie Value = " + value.orElse("N/A");
    }

    // curl -b cookie.txt http://localhost:8080/cookie/get-cookie4
    @GetMapping("/cookie/get-cookie4")
    @ResponseBody
    public String getCookieWithCookie(
            @CookieValue(value= "cookie-value") Cookie cookie
    ){
        return String.format("[%s] : [%s]", cookie.getName(), cookie.getValue());
    }
}
