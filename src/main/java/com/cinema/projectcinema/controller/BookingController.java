package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.entities.Booking;
import com.cinema.projectcinema.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class BookingController {

    public static final Logger logger = Logger.getLogger("BookingController.class");

    @Autowired
    BookingServices bookingServices;

    @PutMapping("/api/v4/updatebooking")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id, @RequestBody Booking booking) {
        logger.info("Booking updated by user!");

        return ResponseEntity.ok(bookingServices.updateBooking(booking, id));
    }
}
