package com.testing.TicketBooking_JDBC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking
{
    private int bookingId;
    private int custId;
    private int showId;
    private int seatCount;
}
