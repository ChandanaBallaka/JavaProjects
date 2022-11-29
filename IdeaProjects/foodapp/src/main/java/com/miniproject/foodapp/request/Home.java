package com.miniproject.foodapp.request;

import lombok.Data;

@Data

public class Home
{
    private String restaurantName;
    private float rating;
    private float avgRating;
    private int restaurantId;
    private boolean freeDelivery;
    private String photoUrl;
    private String address;

    public Home(String restaurantName, float rating, float avgRating, int restaurantId, boolean freeDelivery, String photoUrl, String address) {
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.avgRating = avgRating;
        this.restaurantId = restaurantId;
        this.freeDelivery = freeDelivery;
        this.photoUrl = photoUrl;
        this.address = address;
    }
}
