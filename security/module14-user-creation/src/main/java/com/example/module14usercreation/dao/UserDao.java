package com.example.module14usercreation.dao;

import com.example.module14usercreation.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
public interface UserDao extends JpaRepository<Users, Integer>{

    Users findUsersByUsername(String name);
}
