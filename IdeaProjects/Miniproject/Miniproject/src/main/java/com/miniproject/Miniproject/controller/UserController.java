package com.miniproject.Miniproject.controller;

import com.miniproject.Miniproject.entity.*;
import com.miniproject.Miniproject.service.UserService;
import com.miniproject.Miniproject.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController
{
    @Autowired
    UserService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUp signUp)
    {
        return userService.signUp(signUp);
    }

    @PostMapping("/login/{userId}/{password}")
    public ResponseEntity<List<Home>> logIn(@PathVariable String userId, @PathVariable String password)
    {
        List<Home> home_page = userService.logIn(userId,password);
        if(home_page == null)
        {
            return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(home_page));
        }
    }

    @DeleteMapping("/users/{userId}/{password}")
    public String logout(@PathVariable String userId, @PathVariable String password)
    {
        return userService.logout(userId, password);
    }

    @PutMapping("/users/{userId}")
    public String updateProfile(@RequestBody User user,@PathVariable String userId)
    {
         userService.updateProfile(user, userId);
         return  "profile successfully updated";
    }

    @PostMapping("/tweets")
    public Tweets makeTweet(@RequestBody Tweets tweet)
    {
        return userService.makeTweet(tweet);
    }

    @GetMapping("/userprofile/{userId}")
    public User viewProfile(@PathVariable String userId)
    {
        return userService.viewProfile(userId);
    }

    @PostMapping("/retweets")
    public String retweets(@RequestBody Retweets retweets)
    {
        return userService.retweets(retweets);
    }

    @GetMapping("/home/tweets")
    public List<Tweets> viewTweets()
    {
        return userService.viewTweets();
    }

    @GetMapping("/home/retweets")
    public ResponseEntity<List<Retweets>> viewRetweets()
    {
        List<Retweets> retweetsList = null;
        try
        {
            retweetsList = userService.viewRetweets();
            if(retweetsList != null)
            {
               return ResponseEntity.of(Optional.of(retweetsList));
            }
            else
            {
             return    ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/home/tweets/{userId}")
    public List<Tweets> myTweets(@PathVariable String userId)
    {
        return userService.myTweets(userId);
    }

    @PostMapping("/follow/{userId}/{followingId}")
    public String follow(@PathVariable String userId, @PathVariable String followingId)
    {
        return userService.follow(userId,followingId);
    }

    @GetMapping("/follow/{userId}")
    public int getFollowingCount(@PathVariable String userId)
    {
        return userService.getFollowingCount(userId);
    }

    @GetMapping("/follower/{userId}")
    public int getFollowersCount(@PathVariable String userId)
    {
        return userService.getFollowersCount(userId);
    }

    @PostMapping("/home/like/{userId}/{tweetId}")
    public String likePost(@RequestBody Likes likes, @PathVariable String userId, @PathVariable int tweetId)
    {
       return userService.likePost(likes,userId,tweetId);
    }

    @DeleteMapping("/home/dislike/{userId}/{tweetId}")
    public String disLike(@PathVariable String userId, @PathVariable int tweetId)
    {
        return userService.disLike(userId, tweetId);
    }

    @DeleteMapping("/home/tweets/{userId}/{tweetId}")
    public String deleteTweets(@PathVariable String userId, @PathVariable int tweetId)
    {
        return userService.deleteTweets(userId, tweetId);
    }

    @DeleteMapping("/home/retweets/{userId}/{tweetId}")
    public String deleteRetweets(@PathVariable String userId, @PathVariable int tweetId)
    {
        return userService.deleteRetweets(userId, tweetId);
    }

    @GetMapping("/signup/{userId}")
    public Profile getProfile(@PathVariable String userId)
    {
        return userService.getProfile(userId);
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getPhoneNumber(),
                            jwtRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getPhoneNumber());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JWTResponse(token);
    }
}
