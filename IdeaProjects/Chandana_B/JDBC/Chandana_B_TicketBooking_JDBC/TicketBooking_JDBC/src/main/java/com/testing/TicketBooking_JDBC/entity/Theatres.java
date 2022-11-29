package com.testing.TicketBooking_JDBC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theatres
{
    private int theatreId;
    private String theatreName;
    private String theatreLocation;

}
