package com.miniproject.VotingApp.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ResultPage
{
    private String electionName;
    private Timestamp startDateTime;
}
