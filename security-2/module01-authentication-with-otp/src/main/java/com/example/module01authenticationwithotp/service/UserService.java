package com.example.module01authenticationwithotp.service;

import com.example.module01authenticationwithotp.dao.OtpDao;
import com.example.module01authenticationwithotp.dao.UserDao;
import com.example.module01authenticationwithotp.entity.Otp;
import com.example.module01authenticationwithotp.entity.User;
import com.example.module01authenticationwithotp.util.OptCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OtpDao otpDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userDao.save(user);
    }

    public Otp auth(User user) {
        Optional<User> storedUser = this.userDao.findFirstByUsername(user.getUsername());

        if (storedUser.isPresent()) {

            if (passwordEncoder.matches(user.getPassword(), storedUser.get().getPassword())) {

                return renewOtp(storedUser.get());

            } else {
                throw new BadCredentialsException("username and password doesn't match");
            }

        } else {
            throw new UsernameNotFoundException("username doesn't exist");
        }
    }

    private Otp renewOtp(User user) {
        Optional<Otp> storedOtp = this.otpDao.findFirstByUsername(user.getUsername());
        int code = OptCodeGenerator.generate();

        if (storedOtp.isPresent()) {

            // renew
            storedOtp.get().setOtp(code);

            return storedOtp.get();
        } else {
            Otp otp = new Otp();
            otp.setUsername(user.getUsername());
            otp.setOtp(code);

            return this.otpDao.save(otp);
        }
    }

    public boolean checkOtp(Otp otp) {
        Optional<Otp> storedOtp = this.otpDao.findFirstByOtp(otp.getOtp());

        if (storedOtp.isPresent()) {

            return true;
        } else {
            return false;
        }
    }

}
