package com.noel.myapplication.controller;


import com.noel.myapplication.model.Booking;
import com.noel.myapplication.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class HomeController implements CommandLineRunner {

    private final BookingService bookingService;

    public HomeController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public String home() {
        return "YOLO";
    }

    @GetMapping("/bookings")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @PostMapping("/bookings")
    public Booking add(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("alfa", "bravo", "charlie")
            .forEach(name -> bookingService.save(new Booking(name)));
    }
}
