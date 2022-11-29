package com.miniproject.VotingApp.request;

import lombok.Data;

@Data
public class ResultDetailsResponse
{
    private int voteCount;
    private String fullName;
    private int wardNumber;
    private String partyName;
    private String logoUrl;
}
