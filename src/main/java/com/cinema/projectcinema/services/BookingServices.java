package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Booking;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingServices(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "Id", id));
        bookingRepository.deleteById(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Booking booking, int id) {
        Booking b = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));

        b.setEventRoom(booking.getEventRoom());
        b.setMaxGuestsInRoom(booking.getMaxGuestsInRoom());
        b.setTotalCost(booking.getTotalCost());

        bookingRepository.save(b);

        return b;
    }

}
