package com.robosoft.railReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Ticket
{
    private int ticketId;
    private int passengerId;
}
