package com.example.module01authenticationwithotp.dao;

import com.example.module01authenticationwithotp.entity.Otp;
import com.example.module01authenticationwithotp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpDao extends JpaRepository<Otp, Integer> {

    Optional<Otp> findFirstByUsername(String username);

    Optional<Otp> findFirstByOtp(int otp);
}
