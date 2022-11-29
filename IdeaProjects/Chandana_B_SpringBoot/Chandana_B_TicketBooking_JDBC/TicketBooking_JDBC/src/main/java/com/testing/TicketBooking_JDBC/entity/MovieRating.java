package com.testing.TicketBooking_JDBC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRating
{
    private int custId;
    private int movieId;
    private String reviews;
    private int rating;

}
