package com.springboot.OnlineShopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart
{
    private int cartNo;
    private  String userEmail;
    private String bookName;
    private int cartAmount;



}
