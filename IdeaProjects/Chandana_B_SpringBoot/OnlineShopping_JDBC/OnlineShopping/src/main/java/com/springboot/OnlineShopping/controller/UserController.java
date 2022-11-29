package com.springboot.OnlineShopping.controller;

import com.springboot.OnlineShopping.entity.Book;
import com.springboot.OnlineShopping.entity.Purchased;
import com.springboot.OnlineShopping.entity.ShoppingCart;
import com.springboot.OnlineShopping.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/findallbyuser")
    public List<Book> viewAllBook(){
        return userRepository.viewAllBook();
    }

    @PostMapping("/addtocart")
    public ShoppingCart addToShoppingCart(@RequestBody ShoppingCart sc)
    {
        return userRepository.addToShoppingCart(sc);
    }

    @DeleteMapping("/deleteFromCart/{userEmail}/{bookName}")
    public String removeFromCart(@PathVariable String userEmail,@PathVariable String bookName)
    {
        userRepository.removeFromCart(userEmail,bookName);
        return "Book titled" + " " + bookName + " Successfully deleted";
    }

    @PostMapping("/bookToPurchase")
    public String bookToBuy(@RequestBody Purchased purchased)
    {
        userRepository.bookToBuy(purchased);
        return "Book added to purchased list";
    }

}
