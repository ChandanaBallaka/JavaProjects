package com.japa.robosoft.oneToMany_JPA.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer
{
    @Id
    @GeneratedValue   //ID AUTO GENERATED
    private int id;  // acts as foreign key in product table
    private String name;
    private String email;
    private String gender;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL) //TARGET IS PRODUCT CLASS        //one to many mapping using hibernate
    @JoinColumn(name = "cp_fk", referencedColumnName = "id") //id will act as a foreign key
    private List<Product> products;         //customer can have list of products.
}
