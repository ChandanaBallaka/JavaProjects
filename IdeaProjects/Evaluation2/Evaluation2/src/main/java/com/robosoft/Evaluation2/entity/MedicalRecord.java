package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MedicalRecord
{
    private int reportNumber;
    private String diseaseName;
    private int fileNumber;                                                     //one file consist of many medical report
}
