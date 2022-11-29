package com.miniproject.Miniproject.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Retweets
{
    private int tweetId;
    private String userId;                                           //one user can retweet to many tweets
    private int likes;
    private String description;
    private String hashtags;
    private String posts;
    private String retweetTime;
}
