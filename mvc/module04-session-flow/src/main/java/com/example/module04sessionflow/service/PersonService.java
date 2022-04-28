package com.example.module04sessionflow.service;

import com.example.module04sessionflow.dao.PersonDao;
import com.example.module04sessionflow.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    public void save(Person person) {
        this.personDao.save(person);
    }
}
