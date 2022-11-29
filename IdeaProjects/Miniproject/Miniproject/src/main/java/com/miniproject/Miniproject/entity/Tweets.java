package com.miniproject.Miniproject.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tweets
{
    private int tweetId;
    private String userId;           //one user can make many tweets.
    private String tweet;
    private String hashtags;
    private String posts;
    private int likes;
    private String tweetTime;
}
