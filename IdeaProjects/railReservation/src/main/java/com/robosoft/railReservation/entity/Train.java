package com.robosoft.railReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Train
{
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String availableDays;
    private int ticketId;
}
