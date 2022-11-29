package com.springboot.OnlineShopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
    private String bookName;
    private String authorName;
    private int bookPrice;

}
