package com.miniproject.foodapp.request;

import lombok.Data;

@Data
public class DishResponse
{
    private int dishId;
    private String dishName;
    private String photoUrl;
    private int restaurantCount;
}
