package com.springboot.OnlineShopping.service;

import com.springboot.OnlineShopping.entity.Book;
import com.springboot.OnlineShopping.entity.Purchased;
import com.springboot.OnlineShopping.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Book> viewAllBook()
    {
        String queryinfo = "select * from book";
        return jdbcTemplate.query(queryinfo,new BeanPropertyRowMapper<Book>(Book.class));
    }

    public ShoppingCart addToShoppingCart(ShoppingCart sc)
    {
        String insert_query = "insert into shoppingcart values(?,?,?,?)";
        jdbcTemplate.update(insert_query,sc.getCartNo(),sc.getUserEmail(),sc.getBookName(),sc.getCartAmount());
        return sc;
    }

    public void removeFromCart(String userEmail, String bookName)
     {
          String delete_from_cart = "delete from shoppingcart where userEmail = ? and bookName =?";
        jdbcTemplate.update(delete_from_cart,userEmail,bookName);
//         for(int i=0; i<bookList.size();i++)
//         {
//             if(bookI)
//         }


    }

    public String bookToBuy(Purchased purchased)
    {
        String book_to_buy = "insert into  purchased values(?,?,?,?)";
        jdbcTemplate.update(book_to_buy,purchased.getPurchaseId(),purchased.getUserEmail(),purchased.getBookName(),purchased.getPurchaseAmount());
        return "Book added to purchased list";
    }
}
