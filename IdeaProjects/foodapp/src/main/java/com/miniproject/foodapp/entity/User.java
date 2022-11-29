package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User
{
    private int userId;
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private double latitude;
    private double longitude;
    private String address;
}
