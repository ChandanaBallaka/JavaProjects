package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookAppointment
{
    private int appointmentNumber;
    private int patientId;
    private int doctorId;                            //many doctors have many patients
}
