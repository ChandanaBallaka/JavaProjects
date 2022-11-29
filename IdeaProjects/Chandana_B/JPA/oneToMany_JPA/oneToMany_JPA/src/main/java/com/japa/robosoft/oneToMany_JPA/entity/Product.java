package com.japa.robosoft.oneToMany_JPA.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity  //TABLE AUTO GENERATED
public class Product
{
    @Id  //PRIMARY KEY
    private int pid;
    private String productName;
    private int qty;
    private int price;
}
