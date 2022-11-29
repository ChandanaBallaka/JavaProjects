package com.robosoft.railReservation.service;

import com.robosoft.railReservation.entity.Booking;
import com.robosoft.railReservation.entity.Passenger;
import com.robosoft.railReservation.entity.Ticket;
import com.robosoft.railReservation.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RailwayService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String addPassengers(Passenger passenger)
    {
        try
        {
            String add_passengers = "insert into passenger(name,gender,age) values(?,?,?)";
            jdbcTemplate.update(add_passengers, passenger.getName(), passenger.getGender(), passenger.getAge());
            return "added successfully";
        }
        catch (Exception e)
        {
            return "unable to add";
        }
    }
//    public void addTrain(Train train)
//    {
//        String add_trains = "insert into train"
//    }
    public String addTickets(Ticket tickets)
    {
        try
        {
            String add_trains = "insert into ticket(passengerId) values(?)";
            jdbcTemplate.update(add_trains,tickets.getPassengerId());
            return "added successfully";
        }
        catch (Exception e)
        {
            return "unable to add";
        }
    }

    public String BookTrain(Booking booking)
    {
        try
        {
            String book_train = "insert into booking(bookingDate,numberOfSeats,numberOfSeats,trainNumber) values(?,?,?,?)";
            jdbcTemplate.update(book_train,booking.getBookingDate(),booking.getNumberOfSeats(),booking.getTrainNumber());
            return "added successfully";
        }
        catch (Exception e)
        {
            return "unable to add";
        }
    }

    //public String
}
