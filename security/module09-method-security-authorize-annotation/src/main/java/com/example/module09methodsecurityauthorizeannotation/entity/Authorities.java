package com.example.module09methodsecurityauthorizeannotation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;

    private String authority;

    @ManyToOne
    @JoinColumn(name = "users")
    @JsonIgnore
    private Users users;

    public Authorities() {
    }
}
