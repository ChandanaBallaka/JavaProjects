package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Rating
{
    private int restaurantId;
    private int userId;
    private float rating;
}
