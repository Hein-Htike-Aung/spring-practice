package com.example.module01authenticationwithotp.util;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class OptCodeGenerator {

    public OptCodeGenerator() {
    }

    public static int generate() {

        int code = 0;

        try {

            code = SecureRandom.getInstanceStrong().nextInt(9000) + 1000;

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Problem occurred during generating otp code");
        }

        return code;
    }
}
