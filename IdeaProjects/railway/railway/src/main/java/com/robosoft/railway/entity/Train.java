package com.robosoft.railway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Train
{
    @Id
    @GeneratedValue
    private int trainNumber;
    private int name;
    private String source;
    private String Destination;
    private Date avilableDate;
}
