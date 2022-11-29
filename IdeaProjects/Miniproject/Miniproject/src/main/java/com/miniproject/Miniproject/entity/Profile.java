package com.miniproject.Miniproject.entity;

import lombok.Data;

@Data
public class Profile
{
    private String userName;
    private String userId;
    private boolean verified;
    private String profilePhoto;
}
