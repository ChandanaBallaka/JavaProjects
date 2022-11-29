package com.robosoft.InsuranceDatabase_JDBCTemplate.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car
{
    String regNo;
    String model;
    int year;
}
