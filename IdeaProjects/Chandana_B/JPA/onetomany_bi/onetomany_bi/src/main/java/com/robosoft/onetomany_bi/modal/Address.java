package com.robosoft.onetomany_bi.modal;

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

    @ManyToOne(fetch = FetchType.LAZY,optional = false) //one to many bidirectionaL
    @JoinColumn(name="pid",nullable = false)
 private Person person; //ONE TO MANY BIDIRECTIONAL
}
