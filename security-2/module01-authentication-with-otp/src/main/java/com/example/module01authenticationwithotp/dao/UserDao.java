package com.example.module01authenticationwithotp.dao;

import com.example.module01authenticationwithotp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findFirstByUsername(String username);
}
