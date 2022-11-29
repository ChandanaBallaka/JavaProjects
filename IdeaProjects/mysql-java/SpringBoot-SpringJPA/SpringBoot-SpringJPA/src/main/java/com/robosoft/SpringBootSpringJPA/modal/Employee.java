package com.robosoft.SpringBootSpringJPA.modal;

import jakarta.persistence.*;

@Entity   //to create automatic table
@Table
public class Employee
{

    @Id //ID IS THE PRIMARY KEY

    @GeneratedValue(strategy = GenerationType.AUTO) //@GAENERATEDVALUE annotation is used to specify the primary key and it will automatically generate the values.
    private long id;
    private String name;
    private String city;

    public Employee() {
        super();
    }
    public Employee(String name, String city)
    {
        super();
        this.name = name;
        this.city = city;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
