package com.robosoft.EmployeeSpringBoot.entity;

import lombok.Data;

public @Data class Employee
{
    String name;
    int id;
    String department;
    String location;
}
