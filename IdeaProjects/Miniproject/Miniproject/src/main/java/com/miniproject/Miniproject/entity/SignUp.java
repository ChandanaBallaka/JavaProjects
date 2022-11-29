package com.miniproject.Miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class SignUp
{
    private String userId;
    private String userName;
    private String emailId;
    private String password;
    private String confirmPassword;
}
