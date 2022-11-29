package com.miniproject.VotingApp.request;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class VotingPanel
{
    private String electionName;
    private Timestamp startDateTime;
    private List<VotingResponse> votingResponse;
}
