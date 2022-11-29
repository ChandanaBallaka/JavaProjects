package com.testing.TicketBooking_JDBC.service;

import com.testing.TicketBooking_JDBC.entity.Booking;
import com.testing.TicketBooking_JDBC.entity.Customer;
import com.testing.TicketBooking_JDBC.entity.Movie;
import com.testing.TicketBooking_JDBC.entity.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Adding movie reviews and ratings
    public void addMovieRating(MovieRating rating,int custId)
    {
        String insert_into_ratings = "insert into movierating values(?,?,?,?) ";
        jdbcTemplate.update(insert_into_ratings,custId,rating.getMovieId(),rating.getReviews(),rating.getRating());
    }

    //customer onboarding
    public Customer addCustomer(Customer c)
    {
        String insertquery = "insert into customer values(?,?,?,?,?,?)";
        jdbcTemplate.update(insertquery, c.getCustId(), c.getFName(), c.getLName(), c.getPhoneNumber(), c.getLocation(), c.getCustEmail());
        return c;
    }

    //viewing list of movies available
    public List<Movie> viewAllMovies()
    {
        String queryinfo = "select *from movie";
        return jdbcTemplate.query(queryinfo, new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    //booking the seat for movie
    public void bookSeat(Booking booking)
    {
        String insertquery = "insert into booking values(?,?,?)";
        jdbcTemplate.update(insertquery, booking.getBookingId(), booking.getCustId(), booking.getShowId());
    }


    //update customer information
    public void updateMovie(Customer c, int custId)
    {
        String queryinfo = "Update customer set custEmail = ? where custId = ?";
        jdbcTemplate.update(queryinfo, c.getCustEmail(), custId);
    }

    public List<Booking> viewAllBooking()
    {
        String queryinfo = "select *from booking";
        return jdbcTemplate.query(queryinfo, new BeanPropertyRowMapper<Booking>(Booking.class));
    }


    //customer viewing individual movies
    public Movie getMovie(String title)
    {
        String queryInfo = "select * from movie where title = ?";
        return jdbcTemplate.queryForObject(queryInfo, new Object[]{title}, new BeanPropertyRowMapper<>(Movie.class));
    }

    //customer logging in
    public String customerLogin(int custId, int phoneNumber)
    {
        String queryInfo = "select if(custId = ? and phonenumber = ?, 'LoggedIn Successfully','Invalid username or password') from customer where custId = ?";
        return jdbcTemplate.queryForObject(queryInfo, String.class, new Object[]{custId, phoneNumber, custId});
    }


    //customer booking ticket after logging in
    public int bookTicket(Booking booking, int custId, int phoneNumber)
    {
        String login = customerLogin(custId, phoneNumber);
        int seatAvailable = jdbcTemplate.queryForObject("select no_of_seats from shows where showId =?", Integer.class, new Object[]{booking.getShowId()});
        if (login.equals("LoggedIn Successfully"))
        {
            if (seatAvailable >= booking.getSeatCount())  //maximum number of seats
            {
                String queryInfo = "insert into booking values(?,?,?,?)";    //inserting into booking table
                int status = jdbcTemplate.update(queryInfo, booking.getBookingId(), custId, booking.getShowId(), booking.getSeatCount());
                int movie=jdbcTemplate.queryForObject("select movieId from shows where showId=?", Integer.class,booking.getShowId());
                String insert_into_ratings = "insert into movierating(custId,movieId) values(?,?) ";
                int status2 = jdbcTemplate.update(insert_into_ratings,booking.getCustId(),movie);
                String s = "update shows set no_of_seats = ? where showId =?";
                jdbcTemplate.update(s, new Object[]{seatAvailable - booking.getSeatCount(), booking.getShowId()});
                return status;
            }
        }
        return 0;
    }

    //Adding movie reviews and ratings after logging in
    public int addMovieRating1(MovieRating rating, int custId, int phoneNumber)
    {
        String login = customerLogin(custId, phoneNumber);
        if (login.equals("LoggedIn Successfully"))
        {
            String insert_into_ratings = "insert into movierating values(?,?,?,?) ";
            int status = jdbcTemplate.update(insert_into_ratings,custId,rating.getMovieId(),rating.getReviews(),rating.getRating());
           return status;
        }
        return 0;
    }

    public void updateMovieRating(MovieRating m, int custId, int movieId)  //one review per movie
    {
        String updateRating = "update movierating set reviews = ?,rating = ? where custId = ? and movieId = ?";
        jdbcTemplate.update(updateRating,m.getReviews(),m.getRating(),custId,movieId);
    }

}
