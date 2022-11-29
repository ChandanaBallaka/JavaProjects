package com.testing.TicketBooking_JDBC.controller;

import com.testing.TicketBooking_JDBC.entity.Booking;
import com.testing.TicketBooking_JDBC.entity.Customer;
import com.testing.TicketBooking_JDBC.entity.Movie;
import com.testing.TicketBooking_JDBC.entity.MovieRating;
import com.testing.TicketBooking_JDBC.service.CustomerRepository;
import com.testing.TicketBooking_JDBC.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController
{
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/addCustomer1")
    public Customer addCustomer(@RequestBody Customer c)
    {
       return customerRepository.addCustomer(c);
    }

    @PostMapping("/bookSeat1")                                     //Customer booking for a show
    public void bookSeat(@RequestBody Booking booking)
    {
        customerRepository.bookSeat(booking);
    }

    @GetMapping("/findallMovies")         //customer getting information about movie
    public List<Movie> viewAllMovies()
    {
        return customerRepository.viewAllMovies();
    }

    @PutMapping("/addEmail/{custId}")
    public void updateMovie(@RequestBody Customer c,@PathVariable int custId)
    {
        customerRepository.updateMovie(c,custId);
    }

    @GetMapping("/findallBooking")         //customer can get to know about history of booking.
    public List<Booking> viewAllBooking()
    {
        return customerRepository.viewAllBooking();
    }


    //viewing individual movie
    @GetMapping("/getmovie/{title}")
    public  Movie getMovie(@PathVariable String title)
    {
        return customerRepository.getMovie(title);
    }

    @GetMapping("/login/{custId}/{phoneNumber}")
    public String customerLogin(@PathVariable int custId,@PathVariable int phoneNumber)
    {
        return customerRepository.customerLogin(custId,phoneNumber);
    }

    @PostMapping("/book/{custId}/{phoneNumber}")
    public String bookTicket(@RequestBody Booking booking,@PathVariable int custId,@PathVariable int phoneNumber)
    {
        int result = customerRepository.bookTicket(booking,custId,phoneNumber);
        if(result==1)
            return "Ticket booked Successfully";
        return "Invalid passward or userId....Ticket not booked";
    }

    @PostMapping("/movierating/{custId}")
    public String addMovieRating(@RequestBody MovieRating rating,@PathVariable int custId)
    {
        customerRepository.addMovieRating(rating,custId);
        return "Thank you for your reviews";
    }

    @PostMapping("/movierating1/{custId}/{phoneNumber}")
    public String addMovieRating1(@RequestBody MovieRating rating,@PathVariable int custId,@PathVariable int phoneNumber)
    {
        int result = customerRepository.addMovieRating1(rating,custId,phoneNumber);
        if(result ==0)
        {
            return "Invalid user name or password";
        }
        return "Thank you for your reviews";

    }

    @PutMapping("/rating/{custId}/{movieId}")
    public String updateMovieRating(@RequestBody MovieRating m, @PathVariable int custId,@PathVariable int movieId)
    {
        customerRepository.updateMovieRating(m,custId,movieId);
        return  "updated";
    }

}
