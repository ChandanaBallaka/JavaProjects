package com.robosoft.railReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Passenger
{
    private int passengerId;
    private String name;
    private String gender;
    private int age;
}
