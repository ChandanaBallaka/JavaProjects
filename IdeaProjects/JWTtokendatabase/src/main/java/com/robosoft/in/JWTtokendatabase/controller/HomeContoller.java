package com.robosoft.in.JWTtokendatabase.controller;


import com.robosoft.in.JWTtokendatabase.model.JWTRequest;
import com.robosoft.in.JWTtokendatabase.model.JWTResponse;
import com.robosoft.in.JWTtokendatabase.service.UserService;
import com.robosoft.in.JWTtokendatabase.service.UserServiceImpl;
import com.robosoft.in.JWTtokendatabase.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeContoller
{
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceimpl;

    @GetMapping("/")
    public String home()
    {
        return "Welcome to Robosoft Technologies";
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception
    {

        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JWTResponse(token);
    }

    @PutMapping("/update/{username}")
    public String update(@RequestBody User user, @PathVariable String username)
    {
        return userServiceimpl.updateUser(user,username);
    }

}

