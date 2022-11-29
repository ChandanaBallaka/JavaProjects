package com.robosoft.railReservation.controller;

import com.robosoft.railReservation.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController
{
    @Autowired
    PassengerService passengerService;
}
