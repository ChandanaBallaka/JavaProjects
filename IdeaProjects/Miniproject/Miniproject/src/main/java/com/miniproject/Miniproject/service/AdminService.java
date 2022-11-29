package com.miniproject.Miniproject.service;

import com.miniproject.Miniproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String profileVerification(String userId)                        // admin verifying profiles of user
    {
        String  verify_profile = "update user set verified = ? where userId = ? ";
        try
        {
            jdbcTemplate.update(verify_profile,true,userId);
            return "profile verified";
        }
        catch(Exception e)
        {
            return "failed to update profile";
        }
    }
}
