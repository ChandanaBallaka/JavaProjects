package com.springboot.OnlineShopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchased
{
    private int purchaseId;
    private String userEmail;
    private String bookName;
    private int purchaseAmount;
}
