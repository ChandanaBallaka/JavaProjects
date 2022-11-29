package com.springboot.OnlineShopping.controller;


import com.springboot.OnlineShopping.entity.*;
import com.springboot.OnlineShopping.service.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {
    @Autowired
    ShoppingRepository shoppingRepository;


    @PostMapping("/addAdmin")
    public void addAdmin(@RequestBody Admin admin)
    {
        shoppingRepository.addAdmin(admin);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book)
    {
        shoppingRepository.addBook(book);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)
    { shoppingRepository.addUser(user);}


    @PostMapping("/addPurchased")
    public void addPurchased(@RequestBody Purchased purchased){shoppingRepository.addPurchased(purchased);}

    @PostMapping("/addtoCart")
    public void addCart(@RequestBody ShoppingCart shoppingcart){ shoppingRepository. addCart(shoppingcart);}
}
