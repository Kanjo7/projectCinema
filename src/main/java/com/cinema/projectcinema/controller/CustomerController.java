package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.entities.Customer;
import com.cinema.projectcinema.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerController {

    public static final Logger logger = Logger.getLogger("CustomerController.class");

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/api/v4/add-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        logger.info("New customer added");

        return new ResponseEntity<>(customerServices.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/api/v4/customers")
    public List<Customer> getAllCustomers() {
        logger.info("Showing all customers");

        return customerServices.getAllCustomers();
    }

    @PutMapping("/api/v4/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        logger.info("Customer updated!");

        return ResponseEntity.ok(customerServices.updateCustomer(customer, id));
    }

    @DeleteMapping("/api/deletecustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
        customerServices.deleteCustomer(id);
        logger.info("Customer deleted!");

        return new ResponseEntity<String>("Customer deleted!", HttpStatus.OK);
    }

}
