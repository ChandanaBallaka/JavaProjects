package com.miniproject.Miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class User
{
    private String userId;
    private String password;
    private boolean verified;
    private String profilePhoto;
}
