package com.noel.myapplication.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String bookingName;

}
