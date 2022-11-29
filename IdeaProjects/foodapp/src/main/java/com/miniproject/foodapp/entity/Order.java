package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Order
{
    private int orderId;
    private int cardNumber;
    private Date expiryDate;
    private int cartId;
    private int cvv;
    private String address;
}
