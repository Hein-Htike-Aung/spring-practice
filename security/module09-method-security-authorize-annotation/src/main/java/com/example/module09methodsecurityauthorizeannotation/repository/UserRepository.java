package com.example.module09methodsecurityauthorizeannotation.repository;

import com.example.module09methodsecurityauthorizeannotation.entity.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

//    @Query("select u from Users u where u.name=:name")
    Users findFirstByName(String name);

    // need spring-security-data dependency
    @Query("select u from Users u where u.name=?#{authentication.name}")
    List<Users> findLoginUser();
}
