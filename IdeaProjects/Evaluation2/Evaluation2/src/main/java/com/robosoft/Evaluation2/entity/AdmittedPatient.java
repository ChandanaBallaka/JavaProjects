package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AdmittedPatient
{
    private int admittedId;
    private int wardNumber;
    private int appointmentNumber;
    private int no_of_days;
}
