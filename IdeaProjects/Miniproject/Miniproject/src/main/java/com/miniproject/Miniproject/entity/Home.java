package com.miniproject.Miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Home
{
    private String profilePhoto;
    private String userId;
    private String description;
    private String pictures;
    private int likes;
}
