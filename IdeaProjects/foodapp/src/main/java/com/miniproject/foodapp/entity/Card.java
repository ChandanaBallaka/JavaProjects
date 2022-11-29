package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Card
{
    private int cardNumber;
    private int userId;
    private Date expiryDate;
    private int cvv;

}
