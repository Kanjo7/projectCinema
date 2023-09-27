package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.repositories.BookingRepository;
import com.cinema.projectcinema.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class BookingController {

    public static final Logger logger = Logger.getLogger("BookingController.class");

    @Autowired
    BookingServices bookingServices;


}
