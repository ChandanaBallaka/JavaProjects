package com.testing.oneToOne_BiDirectional.modal;

import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="person_tbl")
public class Person
{
    @Id
    @GeneratedValue
    private int personId;
    private String personName;

  //  @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

}
