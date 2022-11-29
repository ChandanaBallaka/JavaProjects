package com.testing.TicketBooking_JDBC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
    private int custId;
    private String fName;
    private String lName;
    private int phoneNumber;
    private String location;
    private String custEmail;
}
