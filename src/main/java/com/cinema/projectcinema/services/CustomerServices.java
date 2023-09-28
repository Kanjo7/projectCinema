package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Customer;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices implements CustomerServicesInterface {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer c = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setUserName(customer.getUserName());
        c.setAddress(customer.getAddress());

        customerRepository.save(c);
        return c;
    }
}
