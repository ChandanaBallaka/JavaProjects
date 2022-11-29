package com.miniproject.VotingApp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Election
{
    private String electionName;
    private String additionInformation;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Timestamp resultDateTime;

    public void setElectionName(String electionName)
    {
        this.electionName = electionName;
    }

    public void setAdditionInformation(String additionInformation)
    {
        this.additionInformation = additionInformation;
    }

    public void setStartDateTime(String startDateTime)
    {
        this.startDateTime = Timestamp.valueOf(startDateTime);
    }

    public void setEndDateTime(String endDateTime)
    {
        this.endDateTime = Timestamp.valueOf(endDateTime);
    }

    public void setResultDateTime(String resultDateTime)
    {
        this.resultDateTime = Timestamp.valueOf(resultDateTime);
    }
}
