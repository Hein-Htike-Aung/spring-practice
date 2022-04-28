package com.example.module06hateoasrest.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping({"/", "/index"})
    public RepresentationModel index() {

        RepresentationModel representationModel = new RepresentationModel();

        representationModel.add(Link.of("http://localhost:8080/index", "index"));
        representationModel.add(Link.of("http://localhost:8080/customers", "customers"));

        return representationModel;
    }
}
