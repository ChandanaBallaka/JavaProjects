package com.miniproject.Miniproject.service;

import com.miniproject.Miniproject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String signUp(SignUp signUp)                                                      // user signing up to twitter
    {
        try
        {
            String signup_into_twitter = "insert into signup(userId,userName,emailId,password,confirmPassword) values(?,?,?,?,?)";
            if (signUp.getPassword().equals(signUp.getConfirmPassword()))
            {
                jdbcTemplate.update(signup_into_twitter, signUp.getUserId(), signUp.getUserName(), signUp.getEmailId(), signUp.getPassword(), signUp.getConfirmPassword());
                return "LoggedIn successfully";
            }
            else
            {
                return "wrong  password";
            }
        }
        catch (Exception e)
        {
            return "You already have the account";
        }
    }

    public List<Home> logIn(String userId, String password)                                                                    //user logging into twitter
    {
        String check_if_password_correct = "select password from signup where userId = ?";
        String givenPassword = jdbcTemplate.queryForObject(check_if_password_correct,String.class,userId);
        String check_if_userid_correct = "select userId from signup where userId=?";
        String entered_name = jdbcTemplate.queryForObject(check_if_userid_correct, String.class,userId);
        if (givenPassword.equals(password) && entered_name.equals(userId))
        {
            String login_into_twitter = "insert into user(userId,password) values(?,?)";
            jdbcTemplate.update(login_into_twitter,userId,password);
            return getHomePage();
        }
        return null;
    }

    public String logout(String userId, String password)                                            //log out option for user
    {
        String logout = "delete from user where userId = ?";
        jdbcTemplate.update(logout, userId);
        return "Logged out successfully";
    }

    public String updateProfile(User user,String userId)                   //user updating his/her profile
    {
        try
        {
            String update_profile = "update user set password =? , profilePhoto = ?  where userId = ? ";
            jdbcTemplate.update(update_profile, user.getPassword(), user.getProfilePhoto(), userId);
            return "profile updated successfully";
        }
        catch (Exception e)
        {
            return "Unable to update profile";
        }
    }

    public User viewProfile(String userId)                                              // user viewing his profile
    {
        String view_profile = "select *from user where userId = ?";
        return jdbcTemplate.queryForObject(view_profile, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }

    public Tweets makeTweet(Tweets tweet)                                                            // user making tweets
    {
        String make_tweets = "insert into tweets(tweetId,userId,tweet,hashtags,posts,likes,tweetTime) values(?,?,?,?,?,?,now())";
        jdbcTemplate.update(make_tweets,tweet.getTweetId(),tweet.getUserId(),tweet.getTweet(),tweet.getHashtags(),tweet.getPosts(),tweet.getLikes());
        return tweet;
    }

    public String retweets(Retweets retweets)                                                           //user can retweet on the post
    {
        try
        {
            String make_retweet = "insert into retweets(tweetId,userId,likes,description,hashtags,posts,retweetTime) values(?,?,?,?,?,?,now())";
            jdbcTemplate.update(make_retweet, retweets.getTweetId(), retweets.getUserId(), retweets.getLikes(), retweets.getDescription(), retweets.getHashtags(), retweets.getPosts());
            return "retweets";
        }
        catch (Exception e)
        {
            return "Unable to do retweets";
        }
    }

    public List<Tweets> viewTweets()                                                                 //user viewing tweets  on the post
    {
        try
        {
            String view_tweets = "select * from  tweets";
            return jdbcTemplate.query(view_tweets, new BeanPropertyRowMapper<Tweets>(Tweets.class));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public List<Tweets> myTweets(String userId)                                                           //user viewing his tweets
    {
        String my_tweets = "select * from tweets where userId = ?";
        List<Tweets> tweets = jdbcTemplate.query(my_tweets, new Object[]{userId}, new BeanPropertyRowMapper<>(Tweets.class));
        return tweets;
    }

    public List<Retweets> viewRetweets()                                                         //user viewing retweets  on the post
    {
        try
        {
            String view_retweets = "select * from  retweets";
            return jdbcTemplate.query(view_retweets, new BeanPropertyRowMapper<Retweets>(Retweets.class));
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public String follow(String userId,String followingId)
    {
        String follow = "insert into following values(?,?)";
        jdbcTemplate.update(follow,userId,followingId);
        String followedby = "insert into follower(userId,followerId) values(?,?)";
        jdbcTemplate.update(followedby,followingId,userId);
        return "You started following" + userId;
    }

    public int getFollowingCount(String userId)            //  getting following count of a user
    {
        try
        {
            int count = jdbcTemplate.queryForObject("select count(userId) from following where userId=?", Integer.class, new Object[]{userId});
            return count;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public int getFollowersCount(String userId)            //  getting follower count of a user
    {
        try
        {
            int count = jdbcTemplate.queryForObject("select count(userId) from  follower where userId=?", Integer.class, new Object[]{userId});
            return count;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public String likePost(Likes likes,String userId, int tweetId)
    {
        try
        {
            String like_post = "insert into likes(userId,tweetId) values(?,?)";
            jdbcTemplate.update(like_post, userId, tweetId);
            jdbcTemplate.update("update tweets set likes=likes+1 where tweetId=?",tweetId);
            jdbcTemplate.update("update tweets set likes = ?",likeCount(likes.getTweetId()));
            return "You liked the post";
        }
        catch (Exception e)
        {
            return "You already liked this post";
        }
    }
    public String disLike(String userId, int tweetId)
    {
        try
        {
            String dislike_post = "delete  from likes where userId = ? and tweetId = ?";
            jdbcTemplate.update(dislike_post, userId, tweetId);
            return "You disliked the post";
        }
        catch (Exception e)
        {
            return "Error found";
        }
    }
    public int likeCount(int tweetId)
    {
        return jdbcTemplate.queryForObject("select count(tweetId) from likes where tweetId=?", Integer.class,tweetId);
    }
    public String deleteTweets(String userId, int tweetId)
    {
        try
        {
            String delete_tweets = "delete from tweets where userId = ? and tweetId = ?";
            jdbcTemplate.update(delete_tweets,userId,tweetId);
            return "Tweets deleted";
        }
        catch (Exception e)
        {
            return "Unable to delete tweets";
        }
    }
    public String deleteRetweets(String userId, int tweetId)
    {
        try
        {
            String delete_retweets = "delete from retweets where userId = ? and tweetId = ?";
            jdbcTemplate.update(delete_retweets,userId,tweetId);
            return "Retweets deleted";
        }
        catch (Exception e)
        {
            return "Unable to delete retweets";
        }

    }

    public List<Home> getHomePage()         //fetching home page contents
    {
        List<Home> homePageResponses =jdbcTemplate.query("select user.userId,user.profilePhoto,tweets.tweet,tweets.posts,tweets.likes from user inner join tweets on user.userId=tweets.userId",new BeanPropertyRowMapper<>(Home.class));
        return homePageResponses;
    }

    public Profile getProfile(String userId)
    {
        Profile profile = jdbcTemplate.queryForObject("select user.userId,user.profilePhoto,user.verified,signup.userName from user inner join signup on user.userId=signup.userId  where user.userId=?", new BeanPropertyRowMapper<>(Profile.class),userId);
        return profile;
    }

    @Override
    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException
    {
        String emailId = jdbcTemplate.queryForObject("select phoneNumber from user where phoneNumber=?", String.class, new Object[]{mobileNumber});
        String password = jdbcTemplate.queryForObject("select password from user where phoneNumber=?", String.class, new Object[]{mobileNumber});
        return new org.springframework.security.core.userdetails.User(emailId, password, new ArrayList<>());
    }


}
