package com.robosoft.Evaluation2.entity;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Patient
{
    private int patientId;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private int phoneNumber;
}
