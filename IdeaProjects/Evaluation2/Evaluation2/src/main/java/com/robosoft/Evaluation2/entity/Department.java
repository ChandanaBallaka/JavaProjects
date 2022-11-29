package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Department
{
    private String departmentName;
    private String hospitalName;   //one hospital have many department
}
