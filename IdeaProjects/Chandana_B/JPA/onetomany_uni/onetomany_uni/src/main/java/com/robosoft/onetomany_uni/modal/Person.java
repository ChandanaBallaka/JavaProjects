package com.robosoft.onetomany_uni.modal;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person
{
    @Id
    @GeneratedValue
    private int pid;
    private String personName;

  //  @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
   @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pid",referencedColumnName = "pid")
    private List<Address> address;
}
