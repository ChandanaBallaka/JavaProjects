package com.miniproject.foodapp.request;

import lombok.Data;

@Data
public class Filters
{
        private String cuisines;
        private boolean openNow;
        private boolean freeDelivery;
        private double price;
        private String sortBy;

}
