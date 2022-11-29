package com.robosoft.InsuranceDatabase_JDBCTemplate.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accident
{
    int reportNo;
    Date acc_date;
    String location;
}
