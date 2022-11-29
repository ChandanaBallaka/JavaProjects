package com.miniproject.VotingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User
{
    private String phoneNumber;
    private String password;
    private String email;
    private String secretQuestion;
    private String secretAnswer;
}
