package com.example.module04customloginlogout.entity;

import com.example.module04customloginlogout.entity.enums.EncryptionAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Authorities> authorities = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    public Users() {
    }
}
