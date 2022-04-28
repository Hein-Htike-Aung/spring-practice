package com.example.module04sessionflow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    private String profession;

    private String country;

    public Person() {
    }

    // When using session flow, Objects must be splitted in order to validate to each object
    public Person(PersonName personName, PersonProfession personProfession, PersonCountry personCountry) {
        this.name = personName.getName();
        this.profession = personProfession.getProfession();
        this.country = personCountry.getCountry();
    }


}
