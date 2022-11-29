package com.testing.TicketBooking_JDBC.controller;

import com.testing.TicketBooking_JDBC.entity.*;
import com.testing.TicketBooking_JDBC.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)//adding response entity
    {
        int m = userRepository.addMovie(movie);
        if(m==0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of("Added Successfully."));
    }
//
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer c)
    {
        userRepository.addCustomer(c);
    }

    @PostMapping("/addTheatres")
    public void addTheatres(@RequestBody Theatres theatres)
    {
        userRepository.addTheatres(theatres);
    }

    @PostMapping("/addScreen")
    public void addScreen(@RequestBody Screen screen)
    {
       userRepository.addScreen(screen);
    }

    @PostMapping("/addShows")
    public void addShows(@RequestBody Show s)
    {
        userRepository.addShows(s);
    }

    @GetMapping("/findallCustomer")
    public List<Customer> viewAllCustomer()
    {
        return userRepository.viewAllCustomer();
    }


    @PutMapping("/addtitle/{movieId}")
    public void updateMovie(@RequestBody Movie m,@PathVariable int movieId)
    {
        userRepository.updateMovie(m,movieId);
    }
}
