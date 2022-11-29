package com.springboot.OnlineShopping.service;

import com.springboot.OnlineShopping.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminRepository
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addBook(Book book)
    {
        String insertquery = "insert into book values(?,?,?)";
        jdbcTemplate.update(insertquery,book.getAuthorName(),book.getBookPrice(),book.getBookName());
    }

    public List<Book> viewAllBook()
    {
        String queryinfo = "select * from book";
        return jdbcTemplate.query(queryinfo,new BeanPropertyRowMapper<Book>(Book.class));
    }


    public String removeBook(String bookName){
        String query = "delete from book where bookName = ?";
        try {
            int status = jdbcTemplate.update(query, bookName);
            if(status == 1){
                return "Book '"+ bookName + "' removed successfully";
            }
            return "No book found with name " + bookName;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed to remove the book";
    }

    public String updateBookAmount(String bookName, int bookPrice){
      String  query = "update book set bookPrice = ? where BookName = ? ";
        try {
            jdbcTemplate.update(query, bookPrice, bookName);
            return "Book price updated successfully";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Update failed";
    }
}
