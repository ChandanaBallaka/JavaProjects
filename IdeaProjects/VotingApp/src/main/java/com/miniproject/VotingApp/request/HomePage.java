package com.miniproject.VotingApp.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HomePage
{
    private String electionName;
    private Timestamp startDateTime;
}
