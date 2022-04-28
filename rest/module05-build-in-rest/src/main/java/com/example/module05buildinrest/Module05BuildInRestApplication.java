package com.example.module05buildinrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module05BuildInRestApplication {

    // Add Address
    // curl -X POST -H "Content-Type:application/json" -d "{\"addressName\":\"No.45 X_AE _12\"}" localhost:8080/addresses | jq

    // Bind address with customer (using uri)
    // curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:8080/customers/1" http://localhost:8080/addresses/7/customer

    public static void main(String[] args) {
        SpringApplication.run(Module05BuildInRestApplication.class, args);
    }

}
