package com.miniproject.foodapp.request;

import com.miniproject.foodapp.entity.Item;
import lombok.Data;

import java.util.List;

@Data

public class CartItems
{
    private int restaurantId;
    private double amount;
    private List<Item> items;
}
