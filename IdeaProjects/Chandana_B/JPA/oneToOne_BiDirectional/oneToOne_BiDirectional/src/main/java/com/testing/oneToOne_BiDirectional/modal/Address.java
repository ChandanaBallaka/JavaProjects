package com.testing.oneToOne_BiDirectional.modal;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="address_tbl")
public class Address
{
    @Id
    private int addressNo;
    private String location;

    @OneToOne(mappedBy = "address")
    private Person person;

}
