package com.example.module04customloginlogout.dao;

import com.example.module04customloginlogout.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.username=?1")
    Optional<Users> findUsersByUsername(String name);
}
