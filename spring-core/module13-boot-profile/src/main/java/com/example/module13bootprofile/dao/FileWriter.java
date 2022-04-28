package com.example.module13bootprofile.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileWriter implements Writer{
    @Override
    public void write() {
        System.out.println("File Writer");
    }
}
