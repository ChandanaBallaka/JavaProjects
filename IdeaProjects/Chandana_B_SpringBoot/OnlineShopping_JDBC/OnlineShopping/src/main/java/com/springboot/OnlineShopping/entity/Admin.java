package com.springboot.OnlineShopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin
{

    private int adminId;
    private String adminPassword;
    private String adminName;
}
