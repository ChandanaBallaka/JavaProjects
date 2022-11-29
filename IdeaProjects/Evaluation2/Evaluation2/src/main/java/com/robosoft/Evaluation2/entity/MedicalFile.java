package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MedicalFile
{
    private int fileNumber;
    private String findings;
    private String date;
    private int patientId;
}
