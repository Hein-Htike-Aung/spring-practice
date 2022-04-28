package com.example.module11custmizhaspermission.dao;

import com.example.module11custmizhaspermission.Entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UsersDao {

    private Map<String, Users> usersMap = Map.of(
            "karina", new Users("karina", List.of("ADMIN"), List.of("READ", "WRITE")),
            "xiaoting", new Users("xiaoting", List.of("MANAGER"), List.of("READ", "WRITE"))
    );

    public Users getUser(String name) {
        return this.usersMap.get(name);
    }

    public Map<String, Users> getUsersMap() {
        return usersMap;
    }
}
