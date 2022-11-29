package com.japa.testing.oneToOne_JPA.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //to auto generate table
public class Product
{
    @Id //primary key
  //to auto generate id
    private int id;
    private String name;
    private int quantity;
    private double price;
    @OneToOne(mappedBy = "product")
    private Customer customer;

}
