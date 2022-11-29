package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse
{
    private String driver_id;
    private String driver_name;
    private int count;
}
