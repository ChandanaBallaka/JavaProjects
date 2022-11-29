package com.japa.testing.oneToOne_JPA.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer
{
    @Id //primary key
    @GeneratedValue//to auto generate id
    private int custId;
    private String custName;
    private String location;

    @OneToOne
   // @Cascade(CascadeType.ALL)
    private Product product;
}
