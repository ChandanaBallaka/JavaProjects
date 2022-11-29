package com.robosoft.railReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Booking
{
    private int bookingId;
    private Date bookingDate;
    private int numberOfSeats;
    private int trainNumber;
}
