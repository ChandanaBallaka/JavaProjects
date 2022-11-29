package com.miniproject.foodapp.request;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantRequest
{
    private String cuisines;
    private List<RestaurantResponse> restaurantResponseList;
}
