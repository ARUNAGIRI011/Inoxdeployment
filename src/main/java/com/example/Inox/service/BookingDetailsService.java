package com.example.Inox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inox.entity.BookingDetails;
import com.example.Inox.entity.Showtime;
import com.example.Inox.repository.BookingDetailsRepository;
import com.example.Inox.repository.ShowtimeRepository;

@Service
public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<BookingDetails> getAllBookings() {
        return bookingDetailsRepository.findAll();
    }

    public BookingDetails getBookingById(Long id) {
        return bookingDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public BookingDetails addBooking(Long showtimeId, BookingDetails bookingDetails) {
        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found with id: " + showtimeId));
        bookingDetails.setShowtime(showtime);
        return bookingDetailsRepository.save(bookingDetails);
    }

    public void deleteBooking(Long id) {
        bookingDetailsRepository.deleteById(id);
    }
}
