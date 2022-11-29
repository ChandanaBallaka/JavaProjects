package com.robosoft.InsuranceDatabase_JDBCTemplate.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participated
{
    int driver_id;
    String regNo;
    int reportNo;
    int damage_amount;
}
