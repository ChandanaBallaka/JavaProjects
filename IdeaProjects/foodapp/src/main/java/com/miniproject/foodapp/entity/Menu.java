package com.miniproject.foodapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Menu
{
    private int restaurantId;
    private int dishId;
    private double price;
}
