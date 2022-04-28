package com.example.module03onetoone.com.hha.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class BiographicalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateOfBirth;

    private boolean maritalStatus;

    @OneToOne(mappedBy = "biographicalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

    public BiographicalInfo() {
    }

}
