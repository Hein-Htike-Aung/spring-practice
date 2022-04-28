package com.example.module04sessionflow.dao;

import com.example.module04sessionflow.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
}
