package com.miniproject.foodapp.request;

import lombok.Data;

@Data
public class CartInformation
{
    private int quantity;
    private int userId;
    private int dishId;
    private int restaurantId;
    private double amount;
}
