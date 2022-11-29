package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Doctor
{
    private int doctorId;
    private String doctorName;
    private int maxPatient;
    private String departmentName;  //one department have many doctors
}
