package com.noel.myapplication.service;

import com.noel.myapplication.model.Booking;
import com.noel.myapplication.repository.BookingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Test
    public void getAllTest() {
        List<Booking> expectedBookings = Stream.of("alfa", "bravo", "charlie")
            .map(Booking::new)
            .collect(Collectors.toList());

        given(bookingRepository.findAll()).willReturn(expectedBookings);
        List<Booking> bookings = bookingService.getAll();

        assertEquals(bookings.size(), expectedBookings.size());
    }

}