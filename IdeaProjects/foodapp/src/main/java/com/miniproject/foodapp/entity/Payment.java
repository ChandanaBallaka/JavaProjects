package com.miniproject.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Payment
{
    private int paymentId;
    private int orderId;
    private int cartId;
    private int userId;
    private String paymentType;
    private String paymentStatus;
}
