package com.robosoft.SpringBootCurdJDBCApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private int id;
    private String fname;
    private String lname;
    private String email;
}
