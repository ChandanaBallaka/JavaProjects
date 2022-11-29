package com.miniproject.VotingApp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JWTRequest
{
    private String phoneNumber;
    private String password;
}
