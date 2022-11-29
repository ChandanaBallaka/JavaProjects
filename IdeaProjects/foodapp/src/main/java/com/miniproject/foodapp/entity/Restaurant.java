package com.miniproject.foodapp.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Restaurant
{
    private int restaurantId;
    private String restaurantName;
    private float rating;
    private float avgRating;
    private int favourites;
    private boolean freeDelivery;
    private double minimumCost;
    private double latitude;
    private double longitude;
    private String address;
    private Time openTime;
    private Time closeTime;
    private MultipartFile photo;
    private String photoUrl;
}
