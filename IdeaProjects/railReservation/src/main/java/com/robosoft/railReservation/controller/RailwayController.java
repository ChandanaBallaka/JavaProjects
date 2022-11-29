package com.robosoft.railReservation.controller;

import com.robosoft.railReservation.entity.Booking;
import com.robosoft.railReservation.entity.Passenger;
import com.robosoft.railReservation.entity.Ticket;
import com.robosoft.railReservation.service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RailwayController
{
    @Autowired
    RailwayService railwayService;

    @PostMapping("/passengers")
    public String addPassengers(@RequestBody Passenger passenger)
    {
        return railwayService.addPassengers(passenger);
    }

    @PostMapping("/tickets")
    public String addTickets(@RequestBody Ticket tickets)
    {
        return railwayService.addTickets(tickets);
    }

    @PostMapping("/booking")
    public String BookTrain(@RequestBody Booking booking)
    {
        return railwayService.BookTrain(booking);
    }
}
