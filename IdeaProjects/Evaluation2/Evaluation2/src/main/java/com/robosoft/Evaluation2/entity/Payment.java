package com.robosoft.Evaluation2.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Payment
{
   private int amount;
   private int appointmentNumber;
   private String paymentStatus;
}
