package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
