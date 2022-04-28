package com.example.module06hateoasrest.controller;

import com.example.module06hateoasrest.dao.AddressDao;
import com.example.module06hateoasrest.dao.CustomerDao;
import com.example.module06hateoasrest.entity.Address;
import com.example.module06hateoasrest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> customers() {

        List<EntityModel<Customer>> customerEntityModelList =

                StreamSupport.stream(this.customerDao.findAll().spliterator(), false)
                        .map(customer ->
                                EntityModel.of(customer,
                                        linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel(),
                                        linkTo(methodOn(CustomerController.class).getAddresses(customer.getId())).withRel("addresses")
                                )
                        ).collect(Collectors.toList());

        return CollectionModel.of(customerEntityModelList);
    }

    @GetMapping("/customers/{id}/addresses")
    public CollectionModel<EntityModel<Address>> getAddresses(
            @PathVariable("id") int customerId
    ) {

        Customer customer = this.customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<EntityModel<Address>> addressEntityModelList =

                customer.getAddresses().stream()
                        .map(address -> EntityModel.of(address,
                                linkTo(methodOn(CustomerController.class).getAddress(address.getId(), customerId)).withSelfRel(),
                                linkTo(methodOn(CustomerController.class).getCustomer(address.getCustomer().getId())).withRel("customer")

                        )).collect(Collectors.toList());

        return CollectionModel.of(addressEntityModelList);
    }

    @GetMapping("/customers/{customerId}")
    public EntityModel<Customer> getCustomer(
            @PathVariable("customerId") int customerId
    ) {

        Customer customer = this.customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return EntityModel.of(customer,

                linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).customers()).withRel("customers"),
                linkTo(methodOn(CustomerController.class).getAddresses(customer.getId())).withRel("addresses")
        );


    }

    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> getAddress(
            @PathVariable("addressId") int addressId,
            @PathVariable("customerId") int customerId
    ) {

        Customer customer = this.customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Address address = customer.getAddresses().stream()
                .filter(add -> add.getId() == addressId)
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return EntityModel.of(address,
                linkTo(methodOn(CustomerController.class).getAddresses(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withRel("customers")
        );

    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Aung Aung\"}" http://localhost:8080/customers/save
    @PostMapping("/customers/save")
    public EntityModel<Customer> saveCustomer(
            @RequestBody Customer customer
    ) {
        Customer c = this.customerDao.save(customer);

        return EntityModel.of(c,
                linkTo(methodOn(CustomerController.class).getCustomer(c.getId())).withSelfRel()
        );
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"addressName\":\"Nawaday\", \"customer\":\"\"}" http://localhost:8080/customers/4/save/address
    @PostMapping("/customers/{customerId}/save/address")
    public EntityModel<Address> saveAddress(
            @RequestBody Address address,
            @PathVariable("customerId") int id
    ) {
        Customer c = this.customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        c.addAddress(address);
        this.customerDao.save(c);

        return EntityModel.of(address,
                linkTo(methodOn(CustomerController.class).getAddresses(c.getId())).withSelfRel()
        );

    }


}
