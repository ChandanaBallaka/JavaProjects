package com.miniproject.VotingApp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Admin
{
    private int adminId;
    private String adminName;
    private String email;
    private Long phoneNumber;
    private String password;
}
