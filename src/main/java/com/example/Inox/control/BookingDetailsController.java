package com.example.Inox.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inox.entity.BookingDetails;
import com.example.Inox.service.BookingDetailsService;

@RestController
@RequestMapping("/api/bookings")
public class BookingDetailsController {

	    @Autowired
	    private BookingDetailsService bookingDetailsService;

	    @GetMapping
	    public List<BookingDetails> getAllBookings() {
	        return bookingDetailsService.getAllBookings();
	    }

	    @GetMapping("/{id}")
	    public BookingDetails getBookingById(@PathVariable Long id) {
	        return bookingDetailsService.getBookingById(id);
	    }

	    @PostMapping("/{showtimeId}")
	    public BookingDetails addBooking(@PathVariable Long showtimeId, @RequestBody BookingDetails bookingDetails) {
	        return bookingDetailsService.addBooking(showtimeId, bookingDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBooking(@PathVariable Long id) {
	        bookingDetailsService.deleteBooking(id);
	    }
	}

