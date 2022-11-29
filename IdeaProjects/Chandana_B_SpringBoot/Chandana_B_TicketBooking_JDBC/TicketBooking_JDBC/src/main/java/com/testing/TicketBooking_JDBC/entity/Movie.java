package com.testing.TicketBooking_JDBC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
    private int movieId;
    private String title;
    private String description;

}
