package com.miniproject.Miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Followers
{
    private String userId;
    private String followerId;
    private String followStatus;
}
