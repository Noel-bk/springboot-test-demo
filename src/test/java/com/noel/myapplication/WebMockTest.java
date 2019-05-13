package com.noel.myapplication;

import com.noel.myapplication.controller.BookingController;
import com.noel.myapplication.model.Booking;
import com.noel.myapplication.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService service;

    @Test
    public void getAllShouldReturnMessageFromService() throws Exception {
        List<Booking> expectedBookings = Stream.of("alfa", "bravo", "charlie")
            .map(Booking::new)
            .collect(Collectors.toList());

        when(service.getAll()).thenReturn(expectedBookings);

        this.mockMvc.perform(get("/bookings")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString(expectedBookings.get(new Random().nextInt(expectedBookings.size())).getBookingName())));

        verify(service, times(3)).save(any());
        verify(service, times(1)).getAll();
    }

}
