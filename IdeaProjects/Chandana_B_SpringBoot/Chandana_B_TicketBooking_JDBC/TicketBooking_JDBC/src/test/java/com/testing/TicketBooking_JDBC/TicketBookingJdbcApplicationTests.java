package com.testing.TicketBooking_JDBC;

import com.testing.TicketBooking_JDBC.controller.CustomerController;
import com.testing.TicketBooking_JDBC.entity.Customer;
import com.testing.TicketBooking_JDBC.entity.Movie;
import com.testing.TicketBooking_JDBC.entity.Theatres;
import com.testing.TicketBooking_JDBC.service.CustomerRepository;
import com.testing.TicketBooking_JDBC.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TicketBookingJdbcApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	@MockBean
	private UserRepository userRepository;

	@MockBean
	private CustomerRepository customerRepository;
//	@Autowired
//	private CustomerController customerController;

	@Test
	public void addCustomerTest()
	{
		Customer c = new Customer(10,"Chandana","B",8769765,"Sullia","chandanab123@.com");
		when(customerRepository.addCustomer(c)).thenReturn(c);
		assertEquals(c,customerRepository.addCustomer(c));
	}

//	@Test
//	public void  addMovie()
//	{
//		Movie movie = new Movie(1000,"Kantara","Action");
//		when(userRepository.addMovie(movie)).thenReturn(movie);
//		assertEquals(movie,userRepository.addMovie(movie));
//	}

	@Test
	public void addTheatres()
	{
		Theatres theatres = new Theatres(1,"Alankara","Udupi");
		when(userRepository.addTheatres(theatres)).thenReturn(theatres);
		assertEquals(theatres,userRepository.addTheatres(theatres));
	}

	@Test
	public void viewAllCustomerTest()
	{
		when(userRepository.viewAllCustomer()).thenReturn(Stream.of(new Customer(10,"Chandana","B",8769765,"Sullia","chandanab123@.com"),new Customer(11,"Yashwith","K G",7865465,"Putter"," yashu@in.com"),new Customer(12,"Deepika","P Y", 565344,"Sampaje"," deepz@in.com"),new Customer(13,"Shradha","Gowda",995344,"Sampaje","shadd@in.com"),new Customer(14,"Ramya","s", 66506191,"Bainduru"," Ramya@gmail.com"),new Customer(15,"Reenu","Shetty",98765611,"Bainduru","Reenu1@gmail.com")).collect(Collectors.toList()));
		assertEquals(6,userRepository.viewAllCustomer().size());
	}

	@Test
	public void  viewAllMovies()
	{
		when(customerRepository.viewAllMovies()).thenReturn(Stream.of(new Movie(1,"Kantara","Action")).collect(Collectors.toList()));
		assertEquals(1,customerRepository.viewAllMovies().size());
	}

	@Test
	public void getMovieTest()
	{
		String title = "Charli";
		when(customerRepository.getMovie(title)).thenReturn(new Movie(1,"Charli","Movie"));
		assertEquals(new Movie(1,"Charli","Movie"),customerRepository.getMovie(title));
	}

	@Test
	public void customerLoginTest()
	{
		int custId = 100;
		int phoneNumber = 876549;
		when(customerRepository.customerLogin(custId,phoneNumber)).thenReturn("LoggedIn Successfully");
		assertEquals("LoggedIn Successfully",customerRepository.customerLogin(custId,phoneNumber));
	}
}
