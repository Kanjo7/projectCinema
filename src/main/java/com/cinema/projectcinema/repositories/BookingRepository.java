package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.customer.id=?1  ")
    List<Booking> findByCustomer(int id);


}
