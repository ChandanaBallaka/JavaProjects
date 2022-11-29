package com.miniproject.VotingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Ward
{
    private int wardNumber;
    private String wardName;
}
