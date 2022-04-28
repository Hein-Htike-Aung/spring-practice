package com.example.module06tableinheritance.com.hha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MEMBER")
@Entity
public abstract class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone;

    public Member() {
    }
}
