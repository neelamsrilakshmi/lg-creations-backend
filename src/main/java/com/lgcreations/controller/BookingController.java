package com.lgcreations.controller;

import com.lgcreations.model.Booking;
import com.lgcreations.service.BookingService;
import com.lgcreations.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        Booking savedBooking = bookingService.saveBooking(booking);

        String adminBody =
                "New Booking Received\n\n" +
                "Name : " + booking.getName() + "\n" +
                "Email : " + booking.getEmail() + "\n" +
                "Phone : " + booking.getPhone() + "\n" +
                "Package : " + booking.getPackageName() + "\n" +
                "Shoot Type : " + booking.getShootType() + "\n" +
                "Location : " + booking.getLocation() + "\n" +
                "Date : " + booking.getDate() + "\n\n" +
                "Message : " + booking.getMessage();

        emailService.sendMail(
                "lg.creativeideas@gmail.com",
                "New Booking - L&G Creations",
                adminBody
        );

        String customerBody =
                "Hi " + booking.getName() + ",\n\n" +
                "Thank you for booking with L&G Creations.\n\n" +
                "We have received your booking successfully.\n\n" +
                "Our team will contact you soon.\n\n" +
                "Regards,\nL&G Creations";

        emailService.sendMail(
                booking.getEmail(),
                "Booking Confirmation - L&G Creations",
                customerBody
        );

        return savedBooking;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PutMapping("/{id}/status")
    public Booking updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return bookingService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}