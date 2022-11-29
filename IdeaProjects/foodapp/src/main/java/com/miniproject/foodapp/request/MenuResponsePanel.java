package com.miniproject.foodapp.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponsePanel
{
    private String restaurantName;
    private String address;
    private Float rating;
    private Float avgRating;
    private String photoUrl;
    private Boolean freeDelivery;
    List<MenuPanel> menuPanelList;
}
