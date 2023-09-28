package com.cinema.projectcinema.services;

import com.cinema.projectcinema.converter.CurrencyConverter;
import com.cinema.projectcinema.entities.Booking;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookingServices implements BookingServicesInterface {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingServices(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "Id", id));
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking, int id) {
        Booking b = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
        b.setCustomer(booking.getCustomer());
        b.setCinemaRoom(booking.getCinemaRoom());
        b.setGuestsInRoom(booking.getGuestsInRoom());
        b.setSpeaker(booking.isSpeaker());
        b.setPrice(booking.getPrice());

        bookingRepository.save(b);

        return b;
    }

    @Override
    public List<Booking> getBookingByCustomer(int id) throws IOException {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        List<Booking> bookings = bookingRepository.findByCustomer(id);
        for(Booking booking: bookings){
            booking.setPriceInEuro(currencyConverter.convert(booking.getPrice()));
        }
        return bookings;
    }


}
