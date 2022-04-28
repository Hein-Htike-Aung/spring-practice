package com.example.module13bootprofile;

import com.example.module13bootprofile.annotationDao.Reader;
import com.example.module13bootprofile.dao.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module13BootProfileApplication implements CommandLineRunner {

    @Autowired
    private Writer writer;

    @Autowired
    private Reader reader;

    public static void main(String[] args) {
        SpringApplication.run(Module13BootProfileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        writer.write();
        reader.read();
    }
}
