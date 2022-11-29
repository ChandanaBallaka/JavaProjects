package com.miniproject.foodapp.request;

import lombok.Data;

import java.util.List;
@Data
public class FilterResponse
{
    private String cuisines;
    private int count;
    private List<RestaurantResponse> restaurantResponseList;
}
