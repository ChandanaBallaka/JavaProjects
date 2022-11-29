package com.testing.TicketBooking_JDBC.service;

import com.testing.TicketBooking_JDBC.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCustomer(Customer c)
    {
        String insertquery = "insert into customer values(?,?,?,?,?,?)";
        jdbcTemplate.update(insertquery, c.getCustId(), c.getFName(), c.getLName(), c.getPhoneNumber(), c.getLocation(), c.getCustEmail());
    }

    public int addMovie(Movie movie)
    {
        String insertquery = "insert into movie values(?,?,?)";
        return jdbcTemplate.update(insertquery, movie.getMovieId(), movie.getTitle(), movie.getDescription());
    }

    public Theatres addTheatres(Theatres theatres)
    {
        String insertquery = "insert into  theatres values(?,?,?)";
        jdbcTemplate.update(insertquery, theatres.getTheatreId(), theatres.getTheatreName(), theatres.getTheatreLocation());
        return theatres;
    }

    public void addScreen(Screen screen)
    {
        String insertquery = "insert into screen values(?,?)";
        jdbcTemplate.update(insertquery, screen.getScreenId(), screen.getTheatreId());
    }

    public void addShows(Show s)
    {
        String insertquery = "insert into shows values(?,?,?,?,?)";
        jdbcTemplate.update(insertquery, s.getShowId(), s.getMovieId(), s.getScreenId(), s.getShowTiming(), s.getNo_of_seats());
    }

    public void bookSeat(Booking booking)
    {
        String insertquery = "insert into booking values(?,?,?)";
        jdbcTemplate.update(insertquery, booking.getBookingId(), booking.getCustId(), booking.getShowId());
    }


    //view the details of the customers
    public List<Customer> viewAllCustomer()
    {
        String queryinfo = "select * from customer";
        return jdbcTemplate.query(queryinfo, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    //update movie details
    public void updateMovie(Movie m, int movieId)
    {
        String queryinfo = "Update movie set title= ? where movieId = ?";
        jdbcTemplate.update(queryinfo, m.getTitle(), movieId);
    }

}
