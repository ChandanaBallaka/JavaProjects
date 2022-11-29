package com.testing.Employee_JDBC.modal;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    private int empId;
    private String empName;
    private String location;
}
