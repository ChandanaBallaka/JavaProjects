package com.robosoft.in.JWTtokendatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String updateUser(User user, String username)
    {
        jdbcTemplate.update("update userTable set username=?, password=? where username=?",user.getUsername(),user.getPassword(),username);
        return "Profile Updated";
    }
}
