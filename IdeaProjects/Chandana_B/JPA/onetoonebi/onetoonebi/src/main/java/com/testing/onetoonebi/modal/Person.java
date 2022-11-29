package com.testing.onetoonebi.modal;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person
{
    @Id
    @GeneratedValue
    private int personId;
    private String personName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;
}
