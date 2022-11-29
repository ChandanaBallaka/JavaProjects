package com.miniproject.foodapp.request;

import lombok.Data;

@Data
public class RestaurantResponse
{
    private int restaurantId;
    private String restaurantName;
    private float avgRating;
    private float rating;
    private boolean freeDelivery;
    private String address;
    private String photoUrl;
}
