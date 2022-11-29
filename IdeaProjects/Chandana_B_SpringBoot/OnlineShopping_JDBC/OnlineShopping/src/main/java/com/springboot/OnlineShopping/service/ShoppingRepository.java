package com.springboot.OnlineShopping.service;


import com.springboot.OnlineShopping.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShoppingRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addAdmin(Admin admin)
    {
        String insertquery = "insert into admin values(?,?,?)";
        jdbcTemplate.update(insertquery,admin.getAdminId(),admin.getAdminPassword(),admin.getAdminName());
    }

    public void addBook(Book book)
    {
        String insertquery = "insert into book values(?,?,?)";
        jdbcTemplate.update(insertquery,book.getAuthorName(),book.getBookPrice(),book.getBookName());
    }
//
    public void addUser(User user)
    {
        String insertquery = "insert into user values(?,?,?)";
        jdbcTemplate.update(insertquery,user.getUserName(),user.getPhoneNumber(),user.getUserEmail());
    }

    public void addPurchased(Purchased purchased)
    {
        String insertquery = "insert into purchased values(?,?,?,?)";
        jdbcTemplate.update(insertquery,purchased.getPurchaseId(),purchased.getUserEmail(),purchased.getBookName(),purchased.getPurchaseAmount());
    }

    public void addCart(ShoppingCart shoppingcart)
    {
        String insertquery = "insert into  shoppingcart values(?,?,?,?)";
        jdbcTemplate.update(insertquery,shoppingcart.getCartNo(),shoppingcart.getUserEmail(),shoppingcart.getBookName(),shoppingcart.getCartAmount());
    }
}
