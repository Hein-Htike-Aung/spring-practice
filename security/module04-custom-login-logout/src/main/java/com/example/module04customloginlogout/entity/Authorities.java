package com.example.module04customloginlogout.entity;

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

    private String authority;

    @ManyToOne
    private Users users;

    public Authorities() {
    }
}
