package com.testing.onetoonebi.modal;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address
{
    @Id
    private int addressNo;
    private String location;


    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Person person;

}
