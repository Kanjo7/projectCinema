package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Booking;

import java.io.IOException;
import java.util.List;

public interface BookingServicesInterface {

    Booking saveBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking updateBooking(Booking booking, int id);

    void deleteBooking(int id);

    List<Booking>getBookingByCustomer(int id) throws IOException;

}
