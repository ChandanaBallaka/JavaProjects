package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Cart
{
    private int cartId;
    private int userId;
    private int restaurantId;
    private double amount;
}
