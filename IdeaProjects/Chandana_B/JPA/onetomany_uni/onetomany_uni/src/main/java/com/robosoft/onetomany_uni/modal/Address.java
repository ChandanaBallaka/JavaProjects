package com.robosoft.onetomany_uni.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address
{
    @Id
    private int addressNo;
    private String location;

//    @ManyToOne(fetch = FetchType.LAZY) //one to many bidirectionaL
//    private List<Person> person; //ONE TO MANY BIDIRECTIONAL
}
