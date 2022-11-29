package com.testing.TicketBooking_JDBC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show
{
    private int showId;
    private int movieId;
    private int screenId;
    private int showTiming;
    private int no_of_seats;

}
