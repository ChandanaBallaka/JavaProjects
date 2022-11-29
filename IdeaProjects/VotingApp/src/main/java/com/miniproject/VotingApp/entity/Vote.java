package com.miniproject.VotingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Vote
{
   private String electionName;
   private int wardNumber;
   private String voterId;
   private String partyName;
}
