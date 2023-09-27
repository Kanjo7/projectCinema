package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Customer;

import java.util.List;

public interface CustomerServicesInterface {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer, int id);

    void deleteCustomer(int id);
}
