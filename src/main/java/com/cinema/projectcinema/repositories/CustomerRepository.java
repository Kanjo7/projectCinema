package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
