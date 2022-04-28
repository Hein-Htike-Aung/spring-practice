package com.example.module13bootprofile.annotationDao;


public class DatabaseReader implements Reader{
    @Override
    public void read() {
        System.out.println("Database Reader");
    }
}
