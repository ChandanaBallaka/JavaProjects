package com.miniproject.VotingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Candidate
{
    private String fullName;
    private String gender;
    private int age;
    private int wardNumber;
}
