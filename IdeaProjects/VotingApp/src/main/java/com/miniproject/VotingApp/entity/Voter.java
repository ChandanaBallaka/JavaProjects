package com.miniproject.VotingApp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Voter
{
    private String voterId;
    private String fullName;
    private int age;
    private Long aadhaarNumber;
    private Long phoneNumber;
    private String address;
    private int wardNumber;
    private MultipartFile profilePhoto;
    private String photoUrl;
    private String gender;
}
