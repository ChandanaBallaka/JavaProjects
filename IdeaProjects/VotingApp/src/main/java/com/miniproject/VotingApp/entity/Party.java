package com.miniproject.VotingApp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Party
{
    private  String partyName;
    private String fullName;
    private int wardNumber;
    private String electionName;
    private MultipartFile partyLogo;
    private String logoUrl;
    private String voterId;
    private String gender;
    private int age;
    private int voteCount;
    private String partyStatus;
}
